package HankerRank.Waiter;

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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY number
     *  2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        // Write your code here
        List<Integer> answer = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        makeOdds(odds);



        for (int i = 0; i < q; i++) {
            Stack<Integer> A = new Stack<>();
            Stack<Integer> B = new Stack<>();

            for (int j = number.size()-1; j >=0; j--) {
                if(number.get(j) % odds.get(i) == 0){
                    B.push(number.get(j));
                } else {
                    A.push(number.get(j));
                }
            }
            while(!B.empty()){
                answer.add(B.pop());
            }

            number = new ArrayList<>(A);
        }
        for (int i = 0; i < number.size(); i++) {
            answer.add(number.get(i));
        }

        return answer;
    }

    private static void makeOdds(List<Integer> odds ) {
        int num = 10000;
        boolean[] arr = new boolean[num+1];
        arr[0] = arr[1] = false;
        for(int i=2; i<=num; i+=1) {
            arr[i] = true;
        }

        for(int i=2; i*i<=num; i+=1) {
            for(int j=i*i; j<=num; j+=i) {
                arr[j] = false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]) odds.add(i);
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
