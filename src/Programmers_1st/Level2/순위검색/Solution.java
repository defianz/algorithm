package Programmers_1st.Level2.순위검색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {

    String[] lang = new String[]{"cpp","java","python","-"};
    String[] dom = new String[]{"backend","frontend","-"};
    String[] gyung = new String[]{"junior","senior","-"};
    String[] soulf = new String[]{"chicken","pizza","-"};

    void makeKey(HashMap<String,ArrayList<Integer>> hm) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        String key = lang[i]+dom[j]+gyung[k]+soulf[l];
                        ArrayList<Integer> value = new ArrayList<>();
                        hm.put(key,value);
                    }
                }
            }
        }
    }

    int findIdx(ArrayList<Integer> qInfo, int k){

        int l = 0;
        int r = qInfo.size();
        while(l<r){
            int m = (l+r) /2;
            if(qInfo.get(m) < k){
                l = m+1;
            } else {
                r = m;
            }
        }
        return r;
    }



    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        makeKey(hm);


        for (int i = 0; i < info.length; i++) {
            String[] tmp = info[i].split(" ");
            int pt = Integer.parseInt(tmp[4]);
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int m = 0; m < 2; m++) {
                            String key = (j==0? "-":tmp[0])+ (k==0? "-":tmp[1]) + (l==0?"-":tmp[2]) + (m==0?"-":tmp[3]);
                            hm.get(key).add(pt);
                        }
                    }
                }
            }
        }

        for(String a : hm.keySet()){
            Collections.sort(hm.get(a));
        }


        for (int i = 0; i < query.length; i++) {
            String[] qtmp = query[i].replaceAll(" and ", " ").split(" ");
            String qKey = qtmp[0]+qtmp[1]+qtmp[2]+qtmp[3];
            int qPt = Integer.parseInt(qtmp[4]);
            ArrayList<Integer> qInfo = hm.get(qKey);

            int lidx = findIdx(qInfo,qPt);
            answer[i] = qInfo.size()-lidx;
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] a = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] b = new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] tmp = s.solution(a,b);
        for (int i = 0; i < tmp.length; i++) {
            System.out.println("i = " + i);
            System.out.println("tmp[i] = " + tmp[i]);
        }
    }
}