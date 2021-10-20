package HankerRank.EqualStacks;

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
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here

        List<Integer> height1 = new ArrayList<>();
        List<Integer> height2 = new ArrayList<>();
        List<Integer> height3 = new ArrayList<>();

        fillHeight(height1,h1);
        fillHeight(height2,h2);
        fillHeight(height3,h3);


        int idxH2 = height2.size()-1;
        int idxH3 = height3.size()-1;

        for (int i = height1.size()-1; i >= 0; i--) {
            int curH1 = height1.get(i);

            while(idxH2 >= 0 && height2.get(idxH2) > curH1){
                idxH2--;
            }
            while(idxH3 >= 0 && height3.get(idxH3) > curH1 ){
                idxH3--;
            }
            if(idxH2 == -1 || idxH3 == -1 ) return 0;
            if(curH1 == height2.get(idxH2) && curH1 == height3.get(idxH3))
                return curH1;
        }
        return 0;
    }

    private static void fillHeight(List<Integer> height1, List<Integer> h1) {
        int tmp = 0;
        for (int i = h1.size()-1; i >= 0; i--) {
            tmp += h1.get(i);
            height1.add(tmp);
        }
        return;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/defian/input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

