package Programmers.Level2.스킬트리;

class Solution_Solving {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
        String[] tmp = skill.split("");


        for (int i = 0; i < skill_trees.length; i++) {

            int check[] = new int[tmp.length];

            for (int j = 0; j < tmp.length-1; j++) {
                check[j] = skill_trees[i].indexOf(tmp[j]);
            }

            for (int j = 0; j < check.length-1; j++) {
                if(check[j] == -1 ){
                    boolean flag = false;
                    for (int k = j+1; k < check.length; k++) {
                        if(check[k] != -1 ) {
                            flag = true;
                            break;
                        }
                    }
                    if(flag) continue;
                }

                if(check[j] < check[j+1])

            }

        }
        return answer;
    }
}
