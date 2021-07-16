package Programmers.Level3.길찾기게임;

import java.util.Arrays;
import java.util.Comparator;
class Solution {

    int idx = 0;

    class node {
        int idx;
        int x;
        int y;
        node left;
        node right;

        node (int a, int b, int c){
            this.idx = a;
            this.x = b;
            this.y = c;
        }
    }

    void addNode(node parent, node child){
        if(parent.y > child.y){
            if(parent.left == null) parent.left = child;
            else addNode(parent.left,child);
        } else {
            if(parent.right == null) parent.right = child;
            else addNode(parent.right,child);
        }
    }

    void preorder(int[][] answer, node root){
        if(root != null){
            answer[0][idx++] = root.idx;
            preorder(answer,root.left);
            preorder(answer,root.right);
        }
    }

    void postorder(int[][] answer , node root){
        if(root != null){
            postorder(answer,root.left);
            postorder(answer,root.right);
            answer[1][idx++] = root.idx;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];

        node[] nodes = new node[n];

        for (int i = 0; i <n ; i++) {
            nodes[i] = new node(i+1,nodeinfo[i][1],nodeinfo[i][0]);
        }

        Arrays.sort(nodes, new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if(o2.x != o1.x){
                    return o2.x - o1.x;
                } else {
                    return o1.y - o2.y;
                }
            }
        });

        node root = nodes[0];
        for (int i = 1; i < n; i++) {
            addNode(root,nodes[i]);
        }

        preorder(answer , root);
        idx = 0;
        postorder(answer, root);

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tmp = s.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(tmp[i][j]+ " ");
            }
            System.out.println();
        }
    }
}