package Programmers.Level3.여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class Solution {

    boolean[] visited;
    int ticketNum;
    ArrayList<String> answerList;

    void dfs(String start, int cnt, String hap, String[][] tickets){
        if(cnt == ticketNum){
            answerList.add(hap);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(visited[i] || !tickets[i][0].equals(start)) continue;
            visited[i] = true;
            dfs(tickets[i][1],cnt+1,hap+tickets[i][1],tickets);
            visited[i] = false;
        }
    }

    public String[] solution(String[][] tickets) {

        ticketNum = tickets.length;
        visited = new boolean[ticketNum];
        answerList = new ArrayList<>();

        dfs("ICN",0,"ICN",tickets);

        Collections.sort(answerList);

        String[] answer = new String[ticketNum+1];
        String tmp = answerList.get(0);
        String a = "";
        int idx = 0;
        for (int i = 0; i < tmp.length(); i++) {
            a += tmp.charAt(i);
            if((i+1)%3 ==0) {
                answer[idx++] = a;
                a = "";
            }
        }

        return answer;
    }
}
