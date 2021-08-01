package Programmers_1st.Level3.거스름돈;

class Solution_Fail {

    int answer = 0;

    void foo(int rem, int idx, int[] money ){
        if(rem == 0){
            answer++;
            answer %= 1000000007;
            return;
        }
        if(rem < 0 || idx >= money.length) return;


        foo(rem,idx+1,money);
        while(rem > 0){
            rem -= money[idx];
            foo(rem,idx+1,money);
        }
        return;
    }

    public int solution(int n, int[] money) {

        foo(n,0,money);

        return answer;
    }

    public static void main(String[] args) {
        Solution_Fail s = new Solution_Fail();
        System.out.println("s.solution(5,new int[]{1,2,5}) = " + s.solution(5, new int[]{1, 2, 5}));
    }

}