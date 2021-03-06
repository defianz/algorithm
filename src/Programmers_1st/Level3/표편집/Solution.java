package Programmers_1st.Level3.표편집;

import java.util.Stack;

class Solution {

    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int tablesize = n;
        Stack<Integer> st = new Stack<>();

        for (String command : cmd) {
            String[] commandSplit = command.split(" ");
            if (commandSplit[0].equals("U")) {
                k -= Integer.parseInt(commandSplit[1]);
                if (k < 0) k = 0;
            } else if (commandSplit[0].equals("D")) {
                k += Integer.parseInt(commandSplit[1]);
                if (k > tablesize - 1) k = tablesize - 1;
            } else if (commandSplit[0].equals("C")) {
                st.push(k);
                tablesize--;
                if(k == tablesize) k--;
            } else {
                int ret = st.pop();
                if(k>=ret) k++;
                tablesize++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tablesize; i++) {
            sb.append("O");
        }
        while(!st.empty()){
            sb.insert(st.pop().intValue(),'X');
        }
        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(s.solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"}));
    }
}