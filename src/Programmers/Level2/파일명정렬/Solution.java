package Programmers.Level2.파일명정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    class file {
        String head;
        String number;
        String tail;
        int originIndex;

        file(String a, String b, String c,int d){
            this.head = a;
            this.number = b;
            this.tail = c;
            this.originIndex =d;
        }
    }

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        file[] arr = new file[files.length];

        for (int i = 0; i < files.length; i++) {
            String tmp = files[i];
            int len = tmp.length();
            String head = "";
            String number = "";

            Pattern p = Pattern.compile("^\\D+");
            Matcher m = p.matcher(tmp);
            if(m.find()){
                head = m.group(0);
            }

            p = Pattern.compile("[0-9]+");
            m = p.matcher(tmp);
            if(m.find()){
                number = m.group(0);
            }
            String tail = tmp.substring(head.length()+number.length(),len);

            arr[i] = new file(head,number,tail,i);
        }

        Arrays.sort(arr, new Comparator<file>() {
            @Override
            public int compare(file o1, file o2) {
                if(o1.head.toLowerCase().compareTo(o2.head.toLowerCase()) != 0){
                    return o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
                } else {
                    if(Integer.parseInt(o1.number) - Integer.parseInt(o2.number) != 0){
                        return Integer.parseInt(o1.number) - Integer.parseInt(o2.number);
                    } else {
                        return o1.originIndex-o2.originIndex;
                    }
                }
            }
        });

        for (int i = 0; i < files.length; i++) {
            answer[i] = arr[i].head + arr[i].number + arr[i].tail;
        }

        return answer ;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ttmp = s.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
        for (int i = 0; i < ttmp.length; i++) {
            System.out.println("ttmp[i] = " + ttmp[i]);
        }
    }
}