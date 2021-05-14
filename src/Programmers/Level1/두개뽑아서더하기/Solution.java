package Programmers.Level1.두개뽑아서더하기;


import java.util.Iterator;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        TreeSet tmp = new TreeSet();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                tmp.add(numbers[i]+numbers[j]);
            }
        }
        answer = new int[tmp.size()];
        int cnt =0;
       Iterator iter = tmp.iterator();
       while(iter.hasNext()){
           answer[cnt++] = (int)iter.next();
       }
        return answer;
    }
}
