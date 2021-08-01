package Programmers_2nd.Level1.키패드누르기;

import java.util.HashSet;
import java.util.Set;

class Solution {

    class node {
        int r;
        int c;

        node(int a, int b){
            this.r = a;
            this.c = b;
        }
    }

    int calDist(int dest, String now){
        if(now.equals("*") || now.equals("#")){
            if(dest == 2) return 4;
            else if(dest == 5) return 3;
            else if (dest == 8) return 2;
            else return 1;
        } else {
            int nowNum = Integer.parseInt(now)-1;
            int dest1 = dest -1;

            node nowNode = new node(nowNum/3, nowNum%3);
            if(nowNum == -1){
                nowNode = new node(3,1);
            }

            node destNode = new node(dest1 /3,dest1%3);
            if(dest1 == -1) {
                destNode = new node(3, 1);
            }

            int ret = Math.abs(nowNode.r - destNode.r) + Math.abs(nowNode.c - destNode.c);
            return ret;
        }
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        String nowLeft = "*";
        String nowRight = "#";

        Set<Integer> leftSide = new HashSet<>();
        leftSide.add(1);
        leftSide.add(4);
        leftSide.add(7);

        Set<Integer> rightSide = new HashSet<>();
        rightSide.add(3);
        rightSide.add(6);
        rightSide.add(9);


        for (int curNum : numbers) {
            if (leftSide.contains(curNum)) {
                answer += "L";
                nowLeft = String.valueOf(curNum);
            } else if (rightSide.contains(curNum)) {
                answer += "R";
                nowRight = String.valueOf(curNum);
            } else {
                int comp = calDist(curNum,nowLeft) - calDist(curNum,nowRight);
                if(comp < 0) {
                    answer += "L";
                    nowLeft = String.valueOf(curNum);
                } else if (comp > 0){
                    answer += "R";
                    nowRight = String.valueOf(curNum);
                } else {
                    if(hand.equals("right")){
                        answer += "R";
                        nowRight = String.valueOf(curNum);
                    } else {
                        answer += "L";
                        nowLeft = String.valueOf(curNum);
                    }
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
    }
}
