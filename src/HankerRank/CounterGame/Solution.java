package HankerRank.CounterGame;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    static long[] arr;

    public static String counterGame(long n) {
        // Write your code here
        int cnt  = 0;
       arr = new long[64];
        for (int i = 1; i < 64; i++) {
            arr[i] = (long)Math.pow(2,i);
        }

        while(n!=1){
            if(isPower(n)){
                n /= 2;
            } else {
                long tmp = findPow(n);
                n = n-tmp;
            }
            cnt++;
        }
        if(cnt % 2 != 0 ) return "Louise";
        return "Richard";
    }

    private static long findPow(long n) {
        for (int i = arr.length-1; i > 0; i--) {
            if(n > arr[i]) return arr[i];
        }
        return 1;
    }

    private static boolean isPower(long n) {
        for (int i = 1; i < 64; i++) {
            if( n == arr[i]) return true;
        }
        return false;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                String result = Result.counterGame(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}



