package HankerRank.LegoBlocks;

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
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     */

    public static int legoBlocks(int n, int m) {
        // Write your code here
        long mod = (long) (Math.pow(10,9)+7);
        long[] a = new long[1010];
        long[] dp = new long[1010];
        long[] sum = new long[1010];

        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        a[4] = 8;

        for (int i = 5; i <= m; i++) {
            a[i] = (a[i-1] + a[i-2] + a[i-3] + a[i-4]) % mod;
        }

        for (int i = 1; i <= m; i++) {
            sum[i] = (long)Math.pow(a[i],n);
        }

        dp[0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i] = sum[i];
            for (int j = 1; j < i; j++) {
                dp[i] -= dp[j] * sum[i-j];
                dp[i] = (dp[i] % mod + mod) % mod;
            }
        }
        return (int)(dp[m] % mod);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/defian/input.txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
