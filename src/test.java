import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("(int)'{' = " + (int)'{');
        System.out.println("(int)'}' = " + (int)'}');
        System.out.println("'[' = " + (int)'[');
        System.out.println("']' = " + (int)']');
        System.out.println("(int)'(' = " + (int)'(');
        System.out.println("(int)')' = " + (int)')');
        char a = '2';
        System.out.println(a-'0');
//        System.out.println("'2'-'0' = " + '2'-'0');
        System.out.println("Integer.toBinaryString(10) = " + Integer.toBinaryString(10));
        System.out.println("(int)'A' = " + (int)'A');
//        int x = 10;
//        int y = x;
//        y = y-1;
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//
//
//        int[] arr = {12,3,4,5,5};
//        System.out.println("Arrays.stream(arr).max() = " + (Arrays.stream(arr).max().getAsInt()+1));
//        int[] arr2= Arrays.stream(arr).filter(i -> i != 12).toArray();
//        for (int i = 0; i < arr2.length; i++) {
//            System.out.println(arr2[i]);
//        }
//
//        System.out.println(Math.floor(Math.sqrt(3)));
//        System.out.println(Math.sqrt(3));
//        System.out.println((long)Math.sqrt(3));
        System.out.println("(int)'0' = " + (int)'0');
        System.out.println("Integer.toString(1000120390,16) = " + Integer.toString(1000120390,16));
        
        String zzzz = "hihihiasdfa123afsdfasndfj123123123123klasndfl;";

        String[] tmp = zzzz.split("[a-z]");
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }

        System.out.println("(int)'A' = " + (int)'A');
        System.out.println("(int)('A'-'0') = " + (int)('A'-'0'));
        System.out.println("(char)48 = " + (char)48);



    }
}
