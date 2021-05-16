package Programmers.Level2.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

class Solution_Solving {
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            tmp[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (int)(Integer.parseInt(o1)/Math.pow(10,o1.length()-1) - Integer.parseInt(o2)/Math.pow(10,o2.length()-1));
            }
        });

        return answer;
    }
}
