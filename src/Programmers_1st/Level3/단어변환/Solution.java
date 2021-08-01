package Programmers_1st.Level3.단어변환;

class Solution {

    boolean[] check;
    int answer = 51;



    boolean checkString(String a, String b ){
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                if(flag == true) return false;
                else flag = true;
            }
        }
        return flag;
    }

    void dfs(String start, int cnt, String target, String[] words){
        if(start.equals(target)){
            answer = Math.min(cnt,answer);
            return;
        }
        if(cnt == words.length) return;

        for (int i = 0; i < words.length; i++) {
            if(check[i] == false && checkString(start,words[i])){
                check[i] = true;
                dfs(words[i],cnt+1,target,words);
                check[i] = false;
            }
        }
        return;
    }

    public int solution(String begin, String target, String[] words) {

        boolean flag = false;
        for (String a : words){
            if(a.equals(target)) flag = true;
        }
        if(flag == false) return 0;

        check = new boolean[words.length];
        dfs(begin,0,target,words);
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"hit\"\t,\"cog\",\tnew String[]{\"hot\", \"dot\", \"dog\", \"lot\", \"log\", \"cog\"}) = " + s.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}