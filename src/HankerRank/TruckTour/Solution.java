package HankerRank.TruckTour;

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
     * Complete the 'truckTour' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY petrolpumps as parameter.
     */

    class Truck{
        int idx;
        int cnt;
        int girom;

        public Truck(int idx, int cnt, int girom) {
            this.idx = idx;
            this.cnt = cnt;
            this.girom = girom;
        }
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        int n = petrolpumps.size();
        int startIdx = 0;
        int truckGas = 0;
        while(true){
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int gas = petrolpumps.get((startIdx + i) % n).get(0);
                int nextDist = petrolpumps.get((startIdx + i) % n).get(1);
                truckGas += gas;
                if(truckGas - nextDist < 0 ) {
                    startIdx++;
                    truckGas = 0;
                    flag = false;
                    break;
                } else {
                    truckGas -= nextDist;
                }
            }
            if(flag) return startIdx;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> petrolpumps = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                petrolpumps.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
