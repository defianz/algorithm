package Programmers_2nd.Level1.두개뽑아서더하기;

import java.util.HashSet;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int tmp = numbers[i] + numbers[j];
                hs.add(tmp);
            }
        }


        return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}