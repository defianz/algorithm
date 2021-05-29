package Programmers.Level2.수식최대화;

class Solution_Solving {

    long result = 0;
    String[] p = new String[]{"*","+","-"};
    boolean[] visit = new boolean[3];

    void foo(String expression, int cnt, String nowYun){
        if(cnt > 3){
            int hap = Integer.parseInt(expression);
            if(hap < 0) hap *= -1;
            if(result < hap ) result = hap;
        }

        String[] number = expression.split("[*+-]");
        boolean[] check = new boolean[number.length];
        String[] yun = expression.replaceAll("[0-9]","").split("");


        String nxt = "";
        for (int i = 0; i < yun.length; i++) {
            if(yun[i].equals(nowYun)){
                if(yun[i].equals("+")){
                    nxt += String.valueOf(Long.parseLong(number[i]) + Long.parseLong(number[i+1]));
                } else if(yun[i].equals("*")){
                    nxt += String.valueOf(Long.parseLong(number[i]) * Long.parseLong(number[i+1]));
                } else {
                    nxt += String.valueOf(Long.parseLong(number[i]) - Long.parseLong(number[i+1]));
                }
                check[i] = true;
                check[i+1] = true;

            } else {
                if(!check[i]) nxt += number[i];
                nxt += yun[i];
            }
        }

        if(!check[number.length-1]) nxt += String.valueOf(Long.parseLong(number[number.length-1]));

        for (int i = 0; i < 3; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            foo(nxt,cnt+1,p[i]);
            visit[i] = false;
        }

    }


    public long solution(String expression) {



        for (int i = 0; i < 3; i++) {
            visit[i] = true;
            foo(expression,1,p[i]);
            visit[i] = false;
        }
        long answer = result;
        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
        System.out.println("s.solution(\"100-200*300-500+20\") = " + s.solution("100-200*300-500+20"));
        System.out.println("s.solution(\"50*6-3*2\") = " + s.solution("50*6-3*2"));
    }
}