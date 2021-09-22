package Study.weeklychallenge.week5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    void addString(List<String> ll , String[] arr){
        for (String s : arr) {
            ll.add(s);
        }

        for (String s : arr) {
            for (String s1 : arr) {
                ll.add(s+s1);
            }
        }

        for (String s : arr) {
            for (String s1 : arr) {
                for (String s2 : arr) {
                    ll.add(s+s1+s2);
                }
            }
        }

        for (String s : arr) {
            for (String s1 : arr) {
                for (String s2 : arr) {
                    for (String s3 : arr) {
                        ll.add(s+s1+s2+s3);
                    }
                }
            }
        }

        for (String s : arr) {
            for (String s1 : arr) {
                for (String s2 : arr) {
                    for (String s3 : arr) {
                        for (String s4 : arr) {
                            ll.add(s+s1+s2+s3+s4);
                        }
                    }
                }
            }
        }
    }


    public int solution(String word) {
        int answer = 0;
        String[] arr = new String[]{"A","E","I","O","U"};
        List<String> ll = new ArrayList<>();

        addString(ll, arr);

        Collections.sort(ll);
        answer = ll.indexOf(word)+1;

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.solution(\"AAAAE\") = " + s.solution("AAAAE"));
    }
}
