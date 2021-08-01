package Programmers_1st.Level2.캐시;

import java.util.LinkedList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> ll = new LinkedList<>();

        if(cacheSize==0) return cities.length *5;

        for (int i = 0; i < cities.length; i++) {
            String nxt = cities[i].toLowerCase();

            if(ll.size() != 0 && ll.contains(nxt)){
                ll.remove(nxt);
                ll.add(nxt);
                answer += 1;
            } else if (ll.size() >= cacheSize ){
                ll.removeFirst();
                ll.add(nxt);
                answer += 5;
            } else {
                ll.add(nxt);
                answer += 5;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(2,new String[]{\"Jeju\", \"Pangyo\", \"NewYork\", \"newyork\"}) = " + s.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println("s.solution(0,new String[]{\"Jeju\", \"Pangyo\", \"Seoul\", \"NewYork\", \"LA\"}) = " + s.solution(0,new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }
}
