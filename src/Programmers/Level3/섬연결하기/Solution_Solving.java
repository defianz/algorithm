package Programmers.Level3.섬연결하기;
class Solution_Solving {

    public int solution(int n, int[][] costs) {
        int answer = 0;

        int[][] bridge = new int[n][n];
        boolean[][] check = new boolean[n][n];

        for (int i = 0; i < costs.length; i++) {
            int br1 = costs[i][0];
            int br2 = costs[i][1];
            int cost = costs[i][2];

            bridge[br1][br2] = cost;
            bridge[br2][br1] = cost;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
//        System.out.println("s.solution(5,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,3},{2,3,8},{3,4,1}}) = " + s.solution(5, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 3}, {2, 3, 8}, {3, 4, 1}}));
        System.out.println("s.solution(5,new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}) = " + s.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}));

    }
}
