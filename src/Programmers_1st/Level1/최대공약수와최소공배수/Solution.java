package Programmers_1st.Level1.최대공약수와최소공배수;

class Solution {
    public static int gcd(int a, int b){
        if ( b == 0 ) return a;
        int r = a % b;
        a = b;
        b = r;
        return gcd(a,b);
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = lcm(n,m);
        return answer;
    }
}
