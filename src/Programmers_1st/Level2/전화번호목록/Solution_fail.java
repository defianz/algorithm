package Programmers_1st.Level2.전화번호목록;

import java.util.Arrays;
import java.util.Comparator;

class Solution_fail {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (int i = 0; i < phone_book.length; i++) {
            if(phone_book[i+1].startsWith(phone_book[i+1])) return false;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_fail s = new Solution_fail();
        System.out.println("s.solution(new String[]{\"119\", \"97674223\", \"1195524421\"}) = " + s.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println("s.solution(new String[]{\"123\",\"456\",\"789\"}) = " + s.solution(new String[]{"123", "456", "789"}));
    }
}
