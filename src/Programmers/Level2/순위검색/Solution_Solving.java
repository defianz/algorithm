package Programmers.Level2.순위검색;

import java.util.Arrays;
import java.util.Comparator;

class Solution_Solving {

    class appliance {
        String lang;
        String fbe;
        String juse;
        String chpi;
        int zum;

        appliance(String a, String b, String c, String d, int e){
            lang = a;
            fbe = b;
            juse = c;
            chpi = d;
            zum = e;
        }

        String get(){
            return lang + " " + fbe + " "+ juse + " " + chpi + " " + zum;
        }
    }

    boolean testCon(String cur, String con){
        if(con.equals("-")) return true;
        else return cur.equals(con);
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        appliance[] app = new appliance[info.length];

        for (int j = 0; j < info.length; j++) {
            String[] tmp = info[j].split(" ");
            app[j] = new appliance(tmp[0],tmp[1],tmp[2],tmp[3],Integer.parseInt(tmp[4]));
        }

        Arrays.sort(app, new Comparator<appliance>() {
            @Override
            public int compare(appliance o1, appliance o2) {
                return o2.zum-o1.zum;
            }
        });

        for (int i = 0; i < query.length; i++) {
            String[] condition = query[i].replaceAll(" and","").split(" ");
            String lang = condition[0];
            String fbe = condition[1];
            String juse = condition[2];
            String chpi = condition[3];
            int zum = Integer.parseInt(condition[4]);

            for (int j = 0; j < app.length; j++) {
                appliance cur = app[j];
                if(cur.zum < zum) break;

                if(testCon(cur.fbe,fbe)){
                    if(testCon(cur.juse,juse)){
                        if(testCon(cur.chpi,chpi)){
                         if(testCon(cur.lang,lang)){
                                answer[i]++;
                            }
                        }
                    }
                } else {
                    continue;
                }
            }
        }


        return answer;
    }
}