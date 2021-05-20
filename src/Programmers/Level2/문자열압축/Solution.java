package Programmers.Level2.문자열압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length()/2; i++) {
            String tmp = "";

            int idx =0;
            while(idx <= s.length()-i){
                int dcnt = 1;
                String tmp2 = s.substring(idx,idx+i);
                for (int k = idx+i; k <= s.length()-i; k+=i) {
                    if(tmp2.equals(s.substring(k,k+i))){
                        dcnt++;
                    } else {
                        break;
                    }
                }

                if(dcnt != 1){
                    tmp = tmp + dcnt + tmp2;
                    idx = idx + dcnt*i;
                } else{
                    tmp = tmp + tmp2;
                    idx = idx + i;
                }
            }
            if(idx < s.length()){
                for (int j = idx; j < s.length(); j++) {
                    tmp += s.charAt(j);
                }
            }
            if (answer > tmp.length()) answer = tmp.length();
            }



        return answer;
    }

    public static void main(String[] args) {
        System.out.println("new Solution().solution(\"aabbaccc\") = " + new Solution().solution("aabbaccc"));
        System.out.println("new Solution().solution(\"ababcdcdababcdcd\") = " + new Solution().solution("ababcdcdababcdcd"));
    }
}
