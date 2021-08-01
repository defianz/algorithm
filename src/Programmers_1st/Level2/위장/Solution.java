package Programmers_1st.Level2.위장;

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],1);
            } else {
                map.put(clothes[i][1],map.get(clothes[i][1])+1);
            }
        }

        for (int a : map.values()) {
           answer = answer * (a+1);
        }

        return answer-1;
    }
}
//
//import java.util.*;
//        import static java.util.stream.Collectors.*;
//
//class Solution {
//    public int solution(String[][] clothes) {
//        return Arrays.stream(clothes)
//                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
//                .values()
//                .stream()
//                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
//    }
//}