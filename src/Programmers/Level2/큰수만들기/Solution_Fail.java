package Programmers.Level2.큰수만들기;

class Solution_Fail {

    int smax = 0;

    void foo(Boolean[] made, int idx, int cnt, String[] tmp, int k){
        if(cnt == k){
            String result = "";
            for (int i = 0; i < made.length; i++) {
                if(made[i]==false){
                    result += tmp[i];
                }
            }
            if(result.equals("")) return;
            if(smax < Integer.parseInt(result)) smax = Integer.parseInt(result);
            return;
        }
        if(idx >= tmp.length) return;


        foo(made,idx+1,cnt,tmp,k);
        if(idx+1 < tmp.length) {
            made[idx+1] = true;
            foo(made,idx+1,cnt+1,tmp,k);
            made[idx+1]=false;
        }


    }


    public String solution(String number, int k) {
        String answer = "";
        String[] tmp = number.split("");
        Boolean[] made = new Boolean[tmp.length];
        for (int i = 0; i < made.length; i++) {
            made[i] = false;
        }

        foo(made,0,0,tmp,k);

        made[0] = true;
        foo(made,0,1,tmp,k);

        answer = String.valueOf(smax);


        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(\"1924\",2) = " + s.solution("1924", 2));
        // 94가 나와야함
    }
}

