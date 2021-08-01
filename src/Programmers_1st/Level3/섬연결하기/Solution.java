package Programmers_1st.Level3.섬연결하기;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    static int[] parent;

    class edge implements Comparable<edge>{
        int v1;
        int v2;
        int cost;
        edge(int a, int b, int c){
            this.v1 = a;
            this.v2 = b;
            this.cost = c;
        }


        @Override
        public int compareTo(edge o) {
            if(this.cost < o.cost){
                return -1;
            } else if(this.cost == o.cost){
                return 0;
            } else {
                return 1;
            }
        }
    }

    void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x != y){
            parent[y] = x;
        }
    }

    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y ) return true;
        else return false;
    }



    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<edge> edgeList = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            edge tmp = new edge(costs[i][0],costs[i][1],costs[i][2]);
            edgeList.add(tmp);
        }
        Collections.sort(edgeList);

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edgeList.size(); i++) {
            edge e = edgeList.get(i);
            if(!isSameParent(e.v1,e.v2)){
                answer += e.cost;
                union(e.v1,e.v2);
            }
        }
        

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println("s.solution(5,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,3},{2,3,8},{3,4,1}}) = " + s.solution(5, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 3}, {2, 3, 8}, {3, 4, 1}}));
        System.out.println("s.solution(5,new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}) = " + s.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}));

    }
}
