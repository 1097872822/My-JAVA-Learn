package Senior.JAVA.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@description:
 *      // exer: 读写不同的数据类型：
 *      Contain the methods for reading int, double, float, boolean, short, byte and
 *      string values from the keyboard
 *      【包含读取 int、双精度、浮动、布尔、短型、字节和来自键盘的字符串值】
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 13:41
 */
public class Myinput{
        // Read a string from the keyboard
        public static String readString() {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));

            // 声明和初始化字符串
            String string = "";

            // 从键盘获取字符串
            try {
                string = br.readLine();

            } catch (IOException ex) {
                System.out.println(ex);
            }

            // 返回从键盘获取的字符串
            return string;
        }

        // Read an int value from the keyboard
        public static int readInt() {
            return Integer.parseInt(readString());
        }

        // Read a double value from the keyboard
        public static double readDouble() {
            return Double.parseDouble(readString());
        }

        // Read a byte value from the keyboard
        public static double readByte() {
            return Byte.parseByte(readString());
        }

        // Read a short value from the keyboard
        public static double readShort() {
            return Short.parseShort(readString());
        }

        // Read a long value from the keyboard
        public static double readLong() {
            return Long.parseLong(readString());
        }

        // Read a float value from the keyboard
        public static double readFloat() {
            return Float.parseFloat(readString());
        }
    }

