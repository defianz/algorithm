package Programmers.Level2.짝지어제거하기;

class Solution_Sloving
{
    public int solution(String s)
    {
        boolean flag = true;

        while(flag){
            flag = false;
            int idx = 0;
            String tmp = "";
            while(idx < s.length()-1){
                if(s.charAt(idx) == s.charAt(idx+1)){
                    idx += 2;
                    flag = true;
                    continue;
                } else {
                    tmp += s.charAt(idx++);
                }
            }
            s= tmp;
        }

        return s.length()==0 ? 1 : 0;
    }

    public static void main(String[] args) {
        Solution_Sloving s = new Solution_Sloving();
        System.out.println("s.solution(\"baabaa\") = " + s.solution("baabaa"));
        System.out.println("s.solution(\"cdcd\") = " + s.solution("cdcd"));
    }
}
