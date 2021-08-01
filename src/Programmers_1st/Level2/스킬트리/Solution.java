package Programmers_1st.Level2.스킬트리;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] tmp = skill.split("");
        int check[] = new int[tmp.length];

        for (int i = 0; i < skill_trees.length; i++) {

            boolean flag = true;

            int smax = 0;
            for (int j = 0; j < tmp.length; j++) {
                check[j] = skill_trees[i].indexOf(tmp[j]);
                if(check[j] != -1) smax = j;
            }


            for (int j = 0; j < smax; j++) {
                if(check[j] == -1 || check[j] >= check[j+1]) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;

        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"CBD\",new String[]{\"BACDE\",\"CBADF\",\"AECB\",\"BDA\"}) = " + s.solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"}));
    }
}
