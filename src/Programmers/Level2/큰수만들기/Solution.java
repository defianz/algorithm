package Programmers.Level2.큰수만들기;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        List<Integer> arrayNum = Arrays.stream(number.split("")).map(s -> Integer.parseInt(s)).collect(Collectors.toList());

        Deque<Integer> dq = new LinkedList<>();

        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < arrayNum.size(); i++) {
            if(!dq.isEmpty() && dq.peekLast() < arrayNum.get(i)){
               do {
                    dq.pollLast();
                    cnt++;
                    if(cnt == k) {
                        break;
                    }
                }  while(!dq.isEmpty() && dq.peekLast() < arrayNum.get(i));
                dq.add(arrayNum.get(i));
                idx++;
            } else {
                dq.add(arrayNum.get(i));
                idx++;
            }

            if(cnt==k) break;
        }

        if(cnt == 0) return number.substring(0,number.length()-1);

        for (int i = idx; i < arrayNum.size(); i++) {
            dq.add(arrayNum.get(i));
        }

        while(!dq.isEmpty()){
            answer += String.valueOf(dq.pollFirst());
        }



        return answer;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"1924\",2) = " + s.solution("1924", 2));
        System.out.println("s.solution(\"192455\",2) = " + s.solution("192455", 2));
        System.out.println("s.solution(\"4177252841\",4) = " + s.solution("4177252841", 4));
        System.out.println("s.solution('77777', 1) = " + s.solution("77777", 1));
        // 94가 나와야함
    }
}