package Programmers.Level2.후보키;


import java.util.HashSet;
import java.util.Set;

class Solution_Solving {

    Set<String> answerSet = new HashSet<>();
    int colN;

    void foo(String[][] relation, int nowCnt, int chooseCnt, int[] arr, int start){
        if(nowCnt==chooseCnt) {

            String key = "";
            for (int i = 0; i < arr.length; i++) {
                key += arr[i];
            }

            for (String a : answerSet){
                if(a.contains(key) || key.contains(a)) return;
            }

            Set<String> tmp = new HashSet<>();
            for (int i = 0; i < relation.length; i++) {
                String makeKeyValue = "";
                for (int j = 0; j < chooseCnt; j++) {
                    makeKeyValue += relation[i][arr[j]] + " ";
                }

                if (!tmp.isEmpty() && tmp.contains(makeKeyValue)) {
                    return;
                } else {
                    tmp.add(makeKeyValue);
                }
            }

            answerSet.add(key);
            return;
        }

        for (int i = start; i < colN; i++) {
            arr[nowCnt] = i;
            foo(relation,nowCnt+1,chooseCnt,arr,i+1);
        }
    }

    public int solution(String[][] relation) {


        colN = relation[0].length;

        for (int i = 1; i <= colN ; i++) {
            int[] arr = new int[i];
            foo(relation, 0, i, arr, 0);
        }

        int answer = answerSet.size();

        return answer;
    }

    public static void main(String[] args) {
        Solution_Solving s = new Solution_Solving();
//        System.out.println("s.solution(new String[][]{{\"100\",\"ryan\",\"music\",\"2\"},{\"200\",\"apeach\",\"math\",\"2\"},{\"300\",\"tube\",\"computer\",\"3\"},{\"400\",\"con\",\"computer\",\"4\"},{\"500\",\"muzi\",\"music\",\"3\"},{\"600\",\"apeach\",\"music\",\"2\"}}) = " + s.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
//        System.out.println("s.solution(new String[][]{\"a\",\"b\",\"c\"},{\"1\",\"b\",\"c\"},{\"a\",\"b\",\"4\"},{\"a\",\"5\",\"c\"}) = " + s.solution(new String[][]{{"a", "b", "c"}, {"1", "b", "c"}, {"a", "b", "4"}, {"a", "5", "c"}}));
//        System.out.println("s.solution(new String[][]{{\"a\",\"1\",\"4\"},{\"2\",\"1\",\"5\"},{\"a\",\"2\",\"4\"}}) = " + s.solution(new String[][]{{"a", "1", "4"}, {"2", "1", "5"}, {"a", "2", "4"}}));
        System.out.println("s.solution(new String[][]{{\"a\",1,\"aaa\",\"c\",\"ng\"},{\"b\",1,\"bbb\",\"c\",\"g\"},{\"c\",1,\"aaa\",\"d\",\"ng\"},{\"d\",2,\"bbb\",\"d\",\"ng\"}}) = " + s.solution(new String[][]{{"a", "1", "aaa", "c", "ng"}, {"b", "1", "bbb", "c", "g"}, {"c", "1", "aaa", "d", "ng"}, {"d", "2", "bbb", "d", "ng"}}));

    }
}
