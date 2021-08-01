package Programmers_1st.Level2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {


        String[] firstSplitComma = s.substring(1,s.length()-1).split("}.");

        Arrays.sort(firstSplitComma, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        Set<Integer> hs = new HashSet<>();
        ArrayList<Integer> arl = new ArrayList<>();


       for(int j=0; j<firstSplitComma.length; j++){
           String lastString = firstSplitComma[j];
           String makeNumber = "";
           for (int i = 0; i < lastString.length(); i++) {
               char nxt = lastString.charAt(i);
               if(48 <= nxt && nxt <= 57){
                   makeNumber += nxt;
               } else {
                   if(!makeNumber.equals("")){
                       int nxtNumber = Integer.parseInt(makeNumber);
                       if(!hs.contains(nxtNumber))
                       {
                           hs.add(nxtNumber);
                           arl.add(nxtNumber);
                       }
                       makeNumber = "";
                   }
                   continue;
               }
           }
           if(!makeNumber.equals("")){
               int nxtNumber = Integer.parseInt(makeNumber);
               if(!hs.contains(nxtNumber))
               {
                   hs.add(nxtNumber);
                   arl.add(nxtNumber);
               }
           }

       }


        int[] answer = new int[arl.size()];
       
       int idx = 0;
        for(int a : arl){
            answer[idx++]=a;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}