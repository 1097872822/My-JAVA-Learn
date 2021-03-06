## 在java中的锁分为以下（其实就是按照锁的特性和设计来划分）：
+ 1、公平锁/非公平锁
+ 2、可重入锁
+ 3、独享锁/共享锁
+ 4、互斥锁/读写锁
+ 5、乐观锁/悲观锁
+ 6、分段锁
+ 7、偏向锁/轻量级锁/重量级锁
+ 8、自旋锁（java.util.concurrent包下的几乎都是利用锁）

### 而常见的锁也就两种：Synchronized和Lock接口以及ReadWriteLock接口（读写锁）
> Lock接口是jdk5后新添的来实现锁的功能，其实现类：ReentrantLock、WriteLock、ReadLock。其实还有一个接口ReadWriteLock，读写锁（读读共享、读写独享、写读独享、写写独享）。Lock接口与synchronized关键字本质上都是实现同步功能。

### Lock接口提供的 ，synchronized关键字所不具备的特性:
| **特性**                                                     | **描述**                                                     |
| ------------------------------------------------------------ | :----------------------------------------------------------- |
| **尝试性非阻塞地获取锁（tryLock方法）**                      | **当前线程尝试的获取锁，如果这一时段没有被q其他线程获取，则成功的获取锁，否则直接返回false** |
| **能被中断的获取锁（lockInterruptibly()throws InterruptedException）** | **与synchronized不同，获取到锁的线程能够响应中断，当获取到锁的线程被中断时，中断异常将会被抛出，同时锁会被释放。**<br>**两种情况：**<br>**①：当前线程获取锁之前（并未参与获取锁）被其他线程标记interrupt中断，当调用此方法时直接抛出中断异常。**<br>**②：当前线程获取锁，并且锁被其他线程持有，则一直阻塞，此时其他线程来中断此线程，则会抛出中断异常。** |
| **超时获取锁（tryLock(long time,TimeUtil unit)throws InterruptedException）** | **在指定的时间内能够获取锁，超出时间仍热无法获取，则返回**<br>**①：当前线程在指定时间内获取了锁。**<br>**②：当前线程在指定时间内被中断，锁被释放。**<br>**③：当前线程在超出指定的时间，则直接返回false。** |

### 对于ReentrantLock而言，可实现公平锁
> 通过构造函数指定是否需要公平，默认是非公平，区别在与非公平随机性，并且高并发下吞吐量大，公平的话根据请求锁等待的时间长短，等待的长了优先，类似FIFO，吞吐量降低了。
> 锁绑定多个条件: 指ReentrantLock对象可以同时绑定多个Condition条件对象，而在Synchroized中，锁对象的wait方法、notify方法、和notifyall方法可以实现一个隐含条件，如果需要多个，得额外的添加一个锁对象。在ReentrantLock中不需要，只需要创建多个条件对象即可（new Condition()），对应的await()、siganl()、signalAll()。

### synchronized的优势
> synchronized是在JVM层面上实现的，不但可以通过一些监控工具监控synchronized的锁定，而且在代码执行时出现异常，JVM会自动释放锁定，但是使用Lock则不行，lock是通过代码实现的，要保证锁定一定会被释放，就必须将unLock()放到finally{}中

### 应用场景：
> 在资源竞争不激烈的情况下，synchronized关键字的性能优与ReentrantLock，相反，ReentrantLock的性能保持常态，优于关键字。


### 乐观锁 & 悲观锁：
> 不是指什么具体类型的锁，而是指在并发同步的角度。悲观锁认为对于共享资源的并发操作，一定是发生xi修改的，哪怕没有发生修改，也会认为是修改的，因此对于共享资源的操作，悲观锁采取加锁的方式，认为，不加锁的并发操作一定会出现问题。乐观锁认为对于共享资源的并发操作是不会发生修改的，在更新数据的时候，会采用尝试更新，不断重试的方式更新数据。乐观的认为，不加锁的并发操作共享资源是没问题的。从上面的描述看除，乐观锁不加锁的并发操作会带来性能上的提升，悲观锁的使用就是利用synchroized关键字或者lock接口的特性。乐观锁在java中的使用，是无锁编程常常采用的是CAS自旋锁，典型的例子就是并发原子类，通过CAS自旋（spinLock）来更新值。

### 独享锁 & 悲观锁：
> 独享锁是指该锁一次只能被一个线程所持有。共享锁是指可被多个线程所持有。在java中，对ReentrantLock对象以及synchroized关键字而言，是独享锁的。但是对于ReadWriteLock接口而言，其读是共享锁，其写操作是独享锁。读锁的共享锁是可保证并发读的效率，读写、写写、写读的过程中都是互斥的，独享的。独享锁与共享锁在Lock的实现中是通过 AQS（抽象队列同步器）来实现的。

### 互斥锁与读写锁:
> 又名递归锁，是指同一个线程在外层的方法获取到了锁，在进入内层方法会自动获取到锁。对于ReentrantLock和synchronized关键字都是可重入锁的。最大的好处就是能够避免一定程度的死锁。
~~~java  
public sychrnozied void test() {
    //执行逻辑，调用另一个加锁的方法
    test2();
}
public sychronized void test2() {
    //执行业务逻辑

//在上面代码中，sychronized关键字加在类方法上，执行test方法获取当前对象作为监视器的对象锁，然后又调用test2同步方法。
> 一、如果锁是可重入的话，那么当前线程就在调用test2时并不需要再次获取当前锁对象，可以直接进入test2方法。
> 二、如果锁是不具备可重入的话，那么该线程在调用test2前会等待当前对象锁的释放，实际上该对象锁已被当前线程所持有不可能再此获得。那么就会发生死锁。
~~~
## 按照设计方案来分类（目的对锁的进一步优化）:
+ 自旋锁与自适应自旋锁（或者说是自旋锁的变种TicketLock、MCSLock、CLHLock）
> 底层采用CAS来保证原子性，自旋锁获取锁的时候不会阻塞，而是通过不断的while循环的方式尝试获取锁。优点：减少线程上下文切换的消耗，缺点是会消耗CPU。如果锁被占用的时间很短，自旋等待的效果就会非常好，反之，如果锁被占用的时间很长，那么自旋的线程只会白白消耗处理器资源，而不会做任何有用的工作，反而会带来性能上的浪费。
+ 偏向锁、轻量级锁、重量级锁
> 这三种锁是指锁的状态，并且是针对Synchronized，在java通过引入锁升级的机制来实现高校的synchronized。锁的状态是通过对象监视器在对象头中的字段来表明的。
  + 偏向锁：指一段同步代码一直被同一个线程s所访问，那么该线程会自动的获取锁。降低获取锁的代价。
  + 轻量级锁：当锁是偏向锁的时候，被另一个线程所访问，偏向锁就会升级为轻量级锁，其他线程会通过自旋的形式尝试获取锁,不会阻塞，提高性能。
  + 重量级锁：当锁为轻量级锁的时候，另一个线程虽然是自旋，但自旋不会一直持续下去，当自旋一定次数的时候，还没获取到锁
    就会进入阻塞，该锁膨胀为重量级锁。重量级会让其他申请线程阻塞，性能降低。

### 分段锁
> 分段锁其实是一种锁的设计，并不是具体的一种锁，对于ConcurrentHashMap而言，其并发的实现就是通过分段锁的形式来实现高效的并发操作。我们以ConcurrentHashMap来说一下分段锁的含义以及设计思想，ConcurrentHashMap中的分段锁称为Segment，它即类似于HashMap（JDK7与JDK8中HashMap的实现）的结构，即内部拥有一个Entry数组，数组中的每个元素又是一个链表；同时又是一个ReentrantLock（Segment继承了ReentrantLock)。
> <br><br>当需要put元素的时候，并不是对整个hashmap进行加锁，而是先通过hashcode来知道他要放在那一个分段中，然后对这个分段进行加锁，所以当多线程put的时候，只要不是放在一个分段中，就实现了真正的并行的插入。
> <br><br>但是，在统计size的时候，可就是获取hashmap全局信息的时候，就需要获取所有的分段锁才能统计。分段锁的设计目的是细化锁的粒度，当操作不需要更新整个数组的时候，就仅仅针对数组中的一项进行加锁操作