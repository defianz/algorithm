package Programmers_1st.Level2.전화번호목록;

import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> hm = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i],"");
        }

       for( String key : hm.keySet()){
           for (int i = 1; i <= key.length(); i++) {
               if(hm.containsKey(key.substring(0,i))) if(!key.equals(key.substring(0,i))) {
                   return false;
               }
           }
       }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new String[]{\"123\", \"456\", \"789\"}) = " + s.solution(new String[]{"123", "456", "789"}));
    }
}