package Programmers_1st.Level2.방금그곡;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int answerHM = 0;

        m= m.replaceAll("A#","h");
        m=m.replaceAll("B#","i");
        m=m.replaceAll("C#","j");
        m=m.replaceAll("D#","k");
        m=m.replaceAll("E#","l");
        m=m.replaceAll("F#","m");
        m=m.replaceAll("G#","n");



        for(String musicInfo : musicinfos){

            String[] tmp = musicInfo.split(",");
            String[] st = tmp[0].split(":");
            String[] en = tmp[1].split(":");
            int stH = Integer.parseInt(st[0]);
            int stM = Integer.parseInt(st[1]);
            int enH = Integer.parseInt(en[0]);
            int enM = Integer.parseInt(en[1]);

            int totalH = (enH-stH) * 60 + enM - stM;

            String makeAk = "";
            String originAk = tmp[3];
            int originAkLen = originAk.length();

            int idx = 0;
            for (int i = 0; i < totalH; i++) {
                char nxt = originAk.charAt(idx  % originAkLen);
                if(nxt == '#') i -= 1;
                idx++;
                makeAk += nxt;
            }
            if(originAk.charAt(idx % originAkLen) == '#') makeAk += originAk.charAt((idx % originAkLen));

            makeAk= makeAk.replaceAll("A#","h");
            makeAk= makeAk.replaceAll("B#","i");
            makeAk= makeAk.replaceAll("C#","j");
            makeAk= makeAk.replaceAll("D#","k");
            makeAk= makeAk.replaceAll("E#","l");
            makeAk= makeAk.replaceAll("F#","m");
            makeAk = makeAk.replaceAll("G#","n");

            System.out.println("makeAk = " + makeAk);
            System.out.println("m = " + m);
            if(makeAk.contains(m)){
                if(answerHM < totalH){
                    answer = tmp[2];
                    answerHM = totalH;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println(s.solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:02,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//        System.out.println(s.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//        System.out.println("s.solution(\"ABCDEFG\",new String[]{\"12:00,12:14,HELLO,CDEFGRAB\", \"13:00,13:05,WORLD,ABCDEF\"}) = " + s.solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println("s.solution(\"ABC\",new String[]{\"12:00,12:14,HELLO,C#DEFGAB\", \"13:00,13:05,WORLD,ABCDEF\"}) = " + s.solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}