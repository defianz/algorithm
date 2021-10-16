package Study.카카오인턴_보석쇼핑;

import java.util.*;

class Solution_Sloving {
    public int[] solution(String[] gems) {

        Map<String, Integer> hm = new HashMap<>();
        for (String gem : gems) {
            hm.put(gem,0);
        }

        int n = hm.keySet().size();

        int lside = 0;
        int rside = 0;

        Queue<String> q = new LinkedList<>();
        Set<String> hs = new HashSet<>();

        for (rside = 0; rside < gems.length; rside++) {
            String cur = gems[rside];
            if(hs.contains(cur)){
                if(!q.isEmpty() &&q.peek().equals(cur)) {
                    q.poll();
                    lside++;
                    for (int i = lside; i < rside; i++) {
                        if(gems[i].equals(gems[i+1])){
                            q.poll();
                            lside++;
                        } else {
                            break;
                        }
                    }
                }
            }
            q.add(cur);
            hs.add(cur);

            if(hs.size() == n) break;
        }

        for (int i = lside; i < rside; i++) {
            if(gems[i].equals(gems[i+1])){
                q.poll();
                lside++;
            } else {
                break;
            }
        }

        return new int[]{lside+1, rside+1};
    }

    public static void main(String[] args) {
        Solution_Sloving s = new Solution_Sloving();
        int[] solution = s.solution(new String[]{"A","B","B","B","B","B","B","C","B","A"});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
