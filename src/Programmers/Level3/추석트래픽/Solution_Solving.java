package Programmers.Level3.추석트래픽;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution_Solving {

    public int solution(String[] lines) {
        int answer = 0;

        Pattern pattern = Pattern.compile( "2016-09-15 (\\d+):(\\d+):(\\d+).(\\d+) (\\d+)\\.*(\\d*)s");

        for (int i = 0; i < lines.length; i++) {
            Matcher m = pattern.matcher(lines[i]);
            if(m.find()){
                int milLine = 0;
                milLine += Integer.parseInt(m.group(1)) * 60 * 60 * 1000;
                milLine += Integer.parseInt(m.group(2)) * 60 * 1000;
                milLine += Integer.parseInt(m.group(3)) * 1000;
                milLine += Integer.parseInt(m.group(4));
                int end = milLine;
                int start = milLine - (Integer.parseInt(m.group(5))*1000);
                if(m.)
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        System.out.println("s.solution(new String[]{\"2016-09-15 01:00:04.001 2.0s\",\n                \"2016-09-15 01:00:07.000 2s\"}) = " + s.solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
    }
}