package Programmers_1st.Level3.베스트앨범;

import java.util.*;

class Solution {
    class song {
        String genre;
        int play;
        int idx;

        song(String a, int b, int c ){
            this.genre = a;
            this.play = b;
            this.idx = c;
        }
    }


    class genre {
        String name;
        int total;
        genre(String a , int b){
            this.name = a;
            this.total = b;
        }
    }


    public int[] solution(String[] genres, int[] plays) {

        HashMap<String,Integer> tr = new HashMap<>();
        HashMap<String, ArrayList<song>> hm = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            tr.put(genres[i],tr.getOrDefault(genres[i],0)+plays[i]);

            ArrayList<song> tmp = hm.getOrDefault(genres[i],new ArrayList<>());
            tmp.add(new song(genres[i],plays[i],i));
            hm.put(genres[i],tmp);
        }

        genre[] genSorted = new genre[tr.size()];
        int sIdx = 0;
        for (String a : tr.keySet()){
            genSorted[sIdx++]= new genre(a,tr.get(a));
        }
        Arrays.sort(genSorted, new Comparator<genre>() {
            @Override
            public int compare(genre o1, genre o2) {
                return o2.total-o1.total;
            }
        });


        ArrayList<Integer> tt = new ArrayList<>();

        for (genre a : genSorted){
            if(hm.get(a.name).size() == 1){
                tt.add(hm.get(a.name).get(0).idx);
            } else {
                Collections.sort(hm.get(a.name), new Comparator<song>() {
                    @Override
                    public int compare(song o1, song o2) {
                        return o2.play - o1.play;
                    }
                });
                tt.add(hm.get(a.name).get(0).idx);
                tt.add(hm.get(a.name).get(1).idx);
            }
        }

        int[] answer = new int[tt.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = tt.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] tmp = s.solution(new String[]  {"A", "A", "B", "A"}, new int[]{5, 5, 6, 5}  );

        for (int i = 0; i < tmp.length; i++) {
            System.out.println("tmp = " + tmp[i]);
        }
    }
}
