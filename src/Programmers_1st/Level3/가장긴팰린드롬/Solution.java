package Programmers_1st.Level3.가장긴팰린드롬;

class Solution
{    int checkPal(int l, int r, String s){
        boolean flag = true;
        while(l>=0 && r <=s.length()-1){
            if(s.charAt(l) != s.charAt(r)){
                flag = false;
                break;
            }
            l--;
            r++;
        }
        if(flag) return r - l - 1;
        else return r - l - 1;
    }


    public int solution(String s)
    {
        int answer = 1;

       if(s.length() != 1){
           for (int i = 0; i < s.length()-1; i++) {
               answer = Math.max(checkPal(i-1,i+1,s),answer);
               answer = Math.max(checkPal(i-1,i,s),answer);
           }
       }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"abcdcba\") = " + s.solution("abcdcba"));
        System.out.println("s.solution(\"abacde\") = " + s.solution("abacde"));
        System.out.println("s.solution(\"abcabcdcbae\") = " + s.solution("abcabcdcbae"));
        System.out.println("s.solution(\"aaaa\") = " + s.solution("aaaa"));
        System.out.println("s.solution(\"abcde\") = " + s.solution("abcde"));
        System.out.println("s.solution(\"a\") = " + s.solution("a"));
        System.out.println("s.solution(\"abcbaqwertrewqq\") = " + s.solution("abcbaqwertrewqq"));
        System.out.println("s.solution(\"abcbaqwqabcba\") = " + s.solution("abcbaqwqabcba"));
        System.out.println("s.solution(\"abba\") = " + s.solution("abba"));
        System.out.println("s.solution(\"abaabaaaaaaa\") = " + s.solution("abaabaaaaaaa"));
    }
}