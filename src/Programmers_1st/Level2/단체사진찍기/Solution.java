package Programmers_1st.Level2.단체사진찍기;

class Solution {

    static char[] arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];
    static int answer = 0;
    static String[] datas;

    static boolean checkCon(String make, char a, char b, char com, int dist){
        int cal = Math.abs(make.indexOf(a)-make.indexOf(b))-1 ;
        if(com=='<'){
            return  cal < dist;
        } else if (com == '>')
            return cal > dist;
        else return cal == dist;

    }

    static void foo(String make){
        if(make.length() == 8){
            boolean flag = true;
            for (int i = 0; i < datas.length; i++) {
                String con = datas[i];
                if(checkCon(make,con.charAt(0),con.charAt(2),con.charAt(3),con.charAt(4)-'0')){
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }

            if(flag) answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if(visited[i]) continue;
            visited[i]= true;
            foo(make+arr[i]);
            visited[i]=false;
        }

    }

    static public int solution(int n, String[] data) {

        datas = data;
        for (int i = 0; i < 8; i++) {
            visited[i] = false;
        }
        answer = 0;

        for (int i = 0; i < 8; i++) {
            visited[i]= true;
            foo(arr[i]+"");
            visited[i] = false;
        }

        return answer;
    }

}
