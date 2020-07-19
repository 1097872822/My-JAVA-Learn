package Senior.JAVA.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@description:
 *      // exer: 读写不同的数据类型：
 *      Contain the methods for reading int, double, float, boolean, short, byte and
 *      string values from the keyboard
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 13:41
 */
public class Myinput{
        // Read a string from the keyboard
        public static String readString() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Declare and initialize the string
            String string = "";

            // Get the string from the keyboard
            try {
                string = br.readLine();

            } catch (IOException ex) {
                System.out.println(ex);
            }

            // Return the string obtained from the keyboard
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

