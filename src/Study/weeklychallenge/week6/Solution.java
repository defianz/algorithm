package Study.weeklychallenge.week6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {

    class Player implements Comparable<Player>{

        int bunho;
        int weigth;
        double vRate;
        int winBigCnt;

        Player(int bunho, int weigth, double vRate, int winBigCnt){
            this.bunho = bunho;
            this.weigth = weigth;
            this.vRate = vRate;
            this.winBigCnt = winBigCnt;
        }

        @Override
        public int compareTo(Player o) {
            if(vRate > o.vRate){
                return -1;
            } else if(vRate < o.vRate) {
                return 1;
            } else {
                if(winBigCnt > o.winBigCnt){
                    return -1;
                } else if (winBigCnt < o.winBigCnt){
                    return 1;
                } else {
                    if(weigth > o.weigth){
                        return -1;
                    } else if(weigth < o.weigth){
                        return 1;
                    } else {
                        return bunho - o.bunho;
                    }
                }
            }
        }
    }


    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < weights.length; i++) {

            int bunho = i +1;
            int win = 0;
            int lose = 0;
            int winBigCnt = 0;

            for (int j = 0; j < head2head[i].length(); j++) {
                if(head2head[i].charAt(j) == 'W') win++;
                else if(head2head[i].charAt(j) == 'L') lose++;

                if(head2head[i].charAt(j) == 'W' && weights[i] < weights[j]){
                    winBigCnt++;
                }
            }
            double vRate = 0;
            if(win != 0 || lose != 0) vRate = (double) win / (double) (win + lose);

            players.add(new Player(bunho,weights[i],vRate,winBigCnt));
        }

        Collections.sort(players);


        for (int i = 0; i < players.size(); i++) {
            answer[i] = players.get(i).bunho;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(new int[]{50, 82, 75, 120}, new String[]{"NLWL", "WNLL", "LWNW", "WWLN"});
        for (int i : tmp) {
            System.out.println("i = " + i);
        }
    }
}
