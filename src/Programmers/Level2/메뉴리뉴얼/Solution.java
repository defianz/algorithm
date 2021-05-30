package Programmers.Level2.메뉴리뉴얼;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    void dfs(String make, int idx, int end, String orderSort, HashMap<String, Integer> hm){
        if(idx == orderSort.length()){
            if(make.length() == end){
                if(!hm.isEmpty() && hm.containsKey(make)){
                    hm.put(make,hm.get(make)+1);
                } else {
                    hm.put(make,1);
                }
            }
            return;
        }
        dfs(make+orderSort.charAt(idx),idx+1,end,orderSort,hm);
        dfs(make,idx+1,end,orderSort,hm);
    }

    public String[] solution(String[] orders, int[] course) {

        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> arl = new ArrayList<>();

        for (String order : orders){
            int len = order.length();
            String[] tmp = order.split("");
            Arrays.sort(tmp);
            String orderSort ="";
            for (int i = 0; i < tmp.length; i++) {
                orderSort += tmp[i];
            }
            for (int i = 2; i <= orderSort.length() ; i++) {
                dfs("",0, i,orderSort, hm);
            }

        }

        for (int courseN : course) {
            int max = 2;
            for (String a: hm.keySet()){
                if(a.length() == courseN){
                    if(max < hm.get(a)) max = hm.get(a);
                }
            }

            for (String a: hm.keySet()){
                if(a.length() == courseN){
                    if(max == hm.get(a)) arl.add(a);
                }
            }

        }


        String[] answer = new String[arl.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arl.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String[] tmp = s.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2,3,4});
//        String[] tmp= s.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2,3,5});
        String[] tmp= s.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2,3,4});

        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}
