package HankerRank.PalindromeIndex;

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
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int palindromeIndex(String s) {
        // Write your code here
        if(isPalindrome(s)) return -1;
        int start = 0;
        int end = s.length() -1;
        while(start != end){
            if(start == s.length()-1 || end == 0) break;
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
                continue;
            }

            if(s.charAt(end-1) == s.charAt(start) && s.charAt(start+1) == s.charAt(end-2)){
                return end;
            } else {
                return start;
            }
        }
        return -1;
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++)
            if(s.charAt(i) != s.charAt(n-1-i)) return false;
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.palindromeIndex(s);

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
