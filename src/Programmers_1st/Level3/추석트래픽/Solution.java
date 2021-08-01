package Programmers_1st.Level3.추석트래픽;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    class log{
        int start;
        int end;

        log (int a, int b){
            this.start = a;
            this.end = b;
        }
    }

    public int solution(String[] lines) {
        int answer = 0;

        Pattern pattern = Pattern.compile( "2016-09-15 (\\d+):(\\d+):(\\d+)\\.(\\d+) (\\d+)\\.*(\\d*)s");

        log[] logs = new log[lines.length];

        for (int i = 0; i < lines.length; i++) {
            Matcher m = pattern.matcher(lines[i]);
            if(m.find()){
                int milLine = 0;
                milLine += Integer.parseInt(m.group(1)) * 60 * 60 * 1000;
                milLine += Integer.parseInt(m.group(2)) * 60 * 1000;
                milLine += Integer.parseInt(m.group(3)) * 1000;
                milLine += Integer.parseInt(m.group(4));
                int end = milLine;
                int start = milLine - (Integer.parseInt(m.group(5))*1000) +1;
                if(!m.group(6).equals("")) start -= Integer.parseInt(m.group(6));
                logs[i] = new log(start,end);
            }
        }


        for (int i = 0; i < logs.length; i++) {
            log target = logs[i];
            int cnt = 0;
            int tst = target.start-999;
            int tend = target.start;
                        
            for (int j = 0; j < logs.length; j++) {
                if(tend >=  logs[j].start && logs[j].end >= tst) cnt++;
            }
            if(cnt > answer) answer = cnt;

        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(new String[]{\"2016-09-15 01:00:04.001 2.0s\",\n                \"2016-09-15 01:00:07.000 2s\"}) = " + s.solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
        System.out.println("s.solution(new String[]{\"2016-09-15 01:00:04.002 2.0s\",\n                \"2016-09-15 01:00:07.000 2s\"}) = " + s.solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
        System.out.println("s.solution(new String[]{\"2016-09-15 20:59:57.421 0.351s\",\n                \"2016-09-15 20:59:58.233 1.181s\",\n                \"2016-09-15 20:59:58.299 0.8s\",\n                \"2016-09-15 20:59:58.688 1.041s\",\n                \"2016-09-15 20:59:59.591 1.412s\",\n                \"2016-09-15 21:00:00.464 1.466s\",\n                \"2016-09-15 21:00:00.741 1.581s\",\n                \"2016-09-15 21:00:00.748 2.31s\",\n                \"2016-09-15 21:00:00.966 0.381s\",\n                \"2016-09-15 21:00:02.066 2.62s\"}) = " + s.solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
    }
}