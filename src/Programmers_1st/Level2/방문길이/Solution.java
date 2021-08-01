package Programmers_1st.Level2.방문길이;

import java.util.HashSet;

class Solution {

    int makeDirNum (char tmp){
        if(tmp == 'U') return 0;
        else if(tmp == 'R') return 1;
        else if(tmp == 'D') return 2;
        else return 3;
    }

    String makeHash(int a, int b, int c ,int d){
        return String.valueOf(a)+ " " + String.valueOf(b) + " " + String.valueOf(c) + " " + String.valueOf(d);
    }

    public int solution(String dirs) {
        int answer = 0;
        int len = dirs.length();

        HashSet<String> hs = new HashSet<>();

        int  idx = 0, sr = 5, sc = 5, ndir;

        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};

        while(idx < len){
            ndir = makeDirNum(dirs.charAt(idx++));
            int nr = sr + dr[ndir];
            int nc = sc + dc[ndir];

            if(nr <0 || nr > 10 || nc <0 || nc > 10) continue;

            String tmp1 = makeHash(sr,sc,nr,nc);
            String tmp2 = makeHash(nr,nc,sr,sc);

            if(!hs.contains(tmp1) && !hs.contains(tmp2)){
                answer++;
                hs.add(tmp1);
                hs.add(tmp2);
            }
            sr = nr;
            sc = nc;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"ULURRDLLU\") = " + s.solution("ULURRDLLU"));
    }
}
