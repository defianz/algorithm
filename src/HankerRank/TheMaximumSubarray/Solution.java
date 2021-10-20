package HankerRank.TheMaximumSubarray;

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
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {



        // edge case
        int maxValue = arr.get(0);
        for (Integer integer : arr) {
            maxValue = Math.max(integer,maxValue);
        }
        if(maxValue < 0 ) {
            List<Integer> t = new ArrayList<>();
            t.add(maxValue);
            t.add(maxValue);
            return t;
        }

        // Write your code here
        long answer1= 0;
        int answer2 =0;

        long[] culmulate = new long[arr.size()];
        culmulate[0] = arr.get(0);
        if(arr.get(0) > 0 ) answer2 += arr.get(0);
        for (int i = 1; i < culmulate.length; i++) {
            culmulate[i] = culmulate[i-1] + arr.get(i);
            if(arr.get(i) > 0 ) answer2 += arr.get(i);
        }

        long tail = 0;
        for (int head = 0; head < arr.size(); head++) {
            if(culmulate[head] >= 0){
                answer1 = Math.max(culmulate[head] - tail, answer1);
            } else {
                tail = Math.min(culmulate[head],tail);
            }
        }


        List<Integer> answer = new ArrayList<>();
        answer.add((int)answer1);
        answer.add(answer2);
        return answer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/defian/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
