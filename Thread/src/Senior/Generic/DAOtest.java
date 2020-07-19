package Senior.Generic;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 19:53
 */
public class DAOtest {
    @Test
    public void test(){
        CustomerDAO cust = new CustomerDAO();
        cust.add(new Customer());
        List<Customer> list = cust.getIndex(10);
    }
}
