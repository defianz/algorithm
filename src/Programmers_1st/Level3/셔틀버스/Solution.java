package Programmers_1st.Level3.셔틀버스;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {

    boolean compareD(String a, int b) {
        int ah = Integer.parseInt(a.split(":")[0]);
        int am = Integer.parseInt(a.split(":")[1]);
        return ah * 100 + am <= b;
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Arrays.sort(timetable);

        int currH = 9;
        int currM = 0;

        Deque<String> q = new LinkedList<>();
        for (int i = 0; i < timetable.length; i++) {
            if (Integer.parseInt(timetable[i].split(":")[0]) > 18) {
                continue;
            }
            q.add(timetable[i]);
        }

        while (n != 1) {
            n--;
            int cnt = 0;

            while (!q.isEmpty() && compareD(q.peekFirst(), currH * 100 + currM)) {
                q.pollFirst();
                cnt++;
                if (cnt == m) break;
            }


            if (currM + t >= 60) {
                currH += 1;
                currM += t - 60;
            } else {
                currM += t;
            }
        }

        String answerH;
        String answerM;

        if (!q.isEmpty()) {
            if (q.size() < m) {
                answerH = currH < 10 ? "0" + currH : String.valueOf(currH);
                answerM = currM < 10 ? "0" + currM : String.valueOf(currM);
                return answerH + ":" + answerM;
            } else if (q.size() == m) {
                String last = q.peekLast();
                int lastH = Integer.parseInt(last.split(":")[0]);
                int lastM = Integer.parseInt(last.split(":")[1]);

                if (lastM == 0) {
                    lastM = 59;
                    lastH = lastH - 1;
                } else {
                    lastM = lastM - 1;
                }
                answerH = lastH < 10 ? "0" + lastH : String.valueOf(lastH);
                answerM = lastM < 10 ? "0" + lastM : String.valueOf(lastM);
                return answerH + ":" + answerM;
            } else {
                int tmp = 0;
                String last = q.peekFirst();
                while (tmp != m) {
                    tmp++;
                    last = q.pollFirst();
                }

                int lastH = Integer.parseInt(last.split(":")[0]);
                int lastM = Integer.parseInt(last.split(":")[1]);

                if (lastM == 0) {
                    lastM = 59;
                    lastH = lastH - 1;
                } else {
                    lastM = lastM - 1;
                }
                answerH = lastH < 10 ? "0" + lastH : String.valueOf(lastH);
                answerM = lastM < 10 ? "0" + lastM : String.valueOf(lastM);
                return answerH + ":" + answerM;
            }
        }

        answerH = currH < 10 ? "0" + currH : String.valueOf(currH);
        answerM = currM < 10 ? "0" + currM : String.valueOf(currM);
        return answerH + ":" + answerM;
    }
}