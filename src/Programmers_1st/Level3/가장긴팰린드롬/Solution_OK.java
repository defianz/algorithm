package Programmers_1st.Level3.가장긴팰린드롬;

class Solution_OK
{

    public int solution(String s)
    {
        int answer = 1;

        for (int palLen = s.length(); palLen > 1; palLen--) {
            for (int i = 0; i + palLen <= s.length() ; i++) {
                boolean isPal = true;
                for (int j = 0; j < palLen / 2; j++) {
                    if(s.charAt(i+j) != s.charAt(i+palLen-1 - j)){
                        isPal = false;
                        break;
                    }
                }
                if(isPal) return palLen;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_OK s = new Solution_OK();
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