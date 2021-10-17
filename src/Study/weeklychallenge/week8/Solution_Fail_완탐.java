package Study.weeklychallenge.week8;


class Solution_Fail_완탐 {

    int n ;
    int[] check;
    int[][][] sizesAll;
    int ans = 1000 * 1000 + 1;

    public void foo(int idx){
        if(idx == n ){
            calCheck();
            return;
        }

        check[idx] = 0;
        foo(idx+1);
        check[idx] = 1;
        foo(idx+1);
    }

    private void calCheck() {
        int garoBest=0;
        int seroBest=0;
        for (int i = 0; i < n; i++) {
            garoBest = Math.max(garoBest,sizesAll[i][0][check[i]]);
            seroBest = Math.max(seroBest,sizesAll[i][1][check[i]]);
        }
        ans = Math.min(ans, garoBest*seroBest);
        return;
    }

    public int solution(int[][] sizes) {
        n = sizes.length;
        check = new int[n];
        sizesAll = new int[n][2][2];

        for (int i = 0; i < n; i++) {
            sizesAll[i][0][0] = sizes[i][0];
            sizesAll[i][1][0] = sizes[i][1];
            sizesAll[i][0][1] = sizes[i][1];
            sizesAll[i][1][1] = sizes[i][0];
        }


        foo(0);

        return ans;
    }

    public static void main(String[] args) {
        Solution_Fail_완탐 s = new Solution_Fail_완탐();
        System.out.println("s.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}) = " + s.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }
}