import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int x = 10;
        int y = x;
        y = y-1;
        System.out.println("x = " + x);
        System.out.println("y = " + y);


        int[] arr = {12,3,4,5,5};
        System.out.println("Arrays.stream(arr).max() = " + (Arrays.stream(arr).max().getAsInt()+1));
        int[] arr2= Arrays.stream(arr).filter(i -> i != 12).toArray();
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        System.out.println(Math.floor(Math.sqrt(3)));
        System.out.println(Math.sqrt(3));
        System.out.println((long)Math.sqrt(3));
    }
}
