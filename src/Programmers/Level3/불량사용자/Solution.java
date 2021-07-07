package Programmers.Level3.불량사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
    HashSet<String> hs;


    boolean matchStr(String a, String b){
        if(a.length() != b.length()) return false;
        else {
            int len = a.length();
            for (int i = 0; i < len; i++) {
                if(a.charAt(i) == b.charAt(i)) continue;
                else{
                    if(a.charAt(i) != '*') return false;
                    else continue;
                }
            }
            return true;
        }
    }


    void foo(int bidx,String[] user_id, String[] banned_id, boolean[] check){
        if(bidx == banned_id.length){
            PriorityQueue<String> pq = new PriorityQueue<>();
            for (int i = 0; i < check.length; i++) {
                if(check[i]) pq.add(user_id[i]);
            }
            String tmp = "";
            while(!pq.isEmpty()){
                tmp += " " + pq.poll();
            }
            hs.add(tmp);
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if(check[i]) continue;
            if(matchStr(banned_id[bidx],user_id[i])){
                check[i] = true;

                foo(bidx+1,user_id,banned_id,check);
                check[i] = false;
            }
        }
    }



    public int solution(String[] user_id, String[] banned_id) {

        hs = new HashSet<>();

        boolean[] check = new boolean[user_id.length];
        Arrays.sort(user_id);
        Arrays.sort(banned_id);
        foo(0,user_id,banned_id,check);

        return hs.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new String[]{\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"}, new String[]{\"fr*d*\", \"abc1**\"}) = " + s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println("s.solution(new String[]{\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"},new String[]{\"*rodo\", \"*rodo\", \"******\"}) = " + s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
        System.out.println("s.solution(new String[]{\"frodo\", \"fradi\", \"crodo\", \"abc123\", \"frodoc\"},new String[]{\"fr*d*\", \"*rodo\", \"******\", \"******\"}) = " + s.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));
    }
}