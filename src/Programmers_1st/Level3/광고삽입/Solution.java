package Programmers_1st.Level3.광고삽입;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class Solution {

    int strToTime(String s) {
        int ret = 0;
        Pattern p = Pattern.compile("(\\d+):(\\d+):(\\d+)");
        Matcher m = p.matcher(s);
        if (m.find()) {
            ret = Integer.parseInt(m.group(1)) * 3600 + Integer.parseInt(m.group(2)) * 60 + Integer.parseInt(m.group(3));
        }
        return ret;
    }

    String timeToStr(int a) {
        int h = a / 3600;
        int m = (a % 3600) / 60;
        int s = a % 60;

        String H = String.valueOf(h);
        String M = String.valueOf(m);
        String S = String.valueOf(s);


        if (H.length() == 1) H = "0" + H;
        if (S.length() == 1) S = "0" + S;
        if (M.length() == 1) M = "0" + M;

        return H + ":" + M + ":" + S;
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int playtime = strToTime(play_time);
        int advtime = strToTime(adv_time);
        int[] cnt = new int[playtime + 1];

        for (int i = 0; i < logs.length; i++) {
            String[] tmp = logs[i].split("-");
            int start = strToTime(tmp[0]);
            int end = strToTime(tmp[1]);

            for (int j = start; j < end; j++) {
                cnt[j]++;
            }
        }

        int start = 0;
        int end = advtime;
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += cnt[i];
        }

        long max = sum;
        int maxStart = start;
        while (end <= playtime) {
            sum -= cnt[start];
            sum += cnt[end];

            if (sum > max) {
                max = sum;
                maxStart = start + 1;
            }

            start++;
            end++;
        }

        return timeToStr(maxStart);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"02:03:55\",\"00:14:15\",new String[]{\"01:20:15-01:45:14\", \"00:40:31-01:00:00\", \"00:25:50-00:48:29\", \"01:30:59-01:53:29\", \"01:37:44-02:02:30\"}) = " + s.solution("02:03:55", "00:14:15", new String[]{"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"}));
    }
}
