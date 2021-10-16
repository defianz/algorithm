package HankerRank.TimeConversion;

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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        String pmAm = s.substring(8);
        String firstTime = s.substring(0, 8);
        StringBuilder sb = new StringBuilder();
        if (pmAm.equals("PM")) {
            int tmp = Integer.parseInt(firstTime.substring(0, 2));
            if(tmp == 12 ){
                sb.append("12");
            } else sb.append(String.valueOf(12+ tmp));
            sb.append(firstTime.substring(2));
        } else {
            int temp = Integer.parseInt(firstTime.substring(0, 2));
            String tmp;
            if (temp < 12) tmp =  String.valueOf(temp);
            else tmp = String.valueOf( temp - 12);

            if (tmp.length() == 1) {
                sb.append("0");
                sb.append(tmp);
            } else sb.append(tmp);
            sb.append(firstTime.substring(2));
        }
        return sb.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);
        System.out.println("result = " + result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
