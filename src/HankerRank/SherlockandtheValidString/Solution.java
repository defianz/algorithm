package HankerRank.SherlockandtheValidString;

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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
        // Write your code here
        String[] split = s.split("");
        HashMap<String, Integer> hm = new HashMap<>();
        for (String s1 : split) {
            hm.put(s1,hm.getOrDefault(s1,0)+1);
        }

        List<Integer> ll = new ArrayList<>();
        for (String s1 : hm.keySet()) {
            ll.add(hm.get(s1));
        }
        Collections.sort(ll,Collections.reverseOrder());

        if(cal(ll,ll.get(0)))return "YES";
        else if(cal(ll,ll.get(0)-1)) return "YES";

        ll.remove(ll.size()-1);
        if(cal(ll,ll.get(0))) return "YES";

        return "NO";
    }

    private static boolean cal(List<Integer> ll, int gap) {
        for (int i = 1; i < ll.size(); i++) {
            if(ll.get(i) != gap ) return false;
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "aabbc";

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
