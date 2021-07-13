package Programmers.Level3.매칭점수;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    class pag {

        String pageUrl;
        double defaultJum;
        ArrayList<String> link;
        int oriIndx;
        double linkJum;
        double totalPt;

        @Override
        public String toString() {
            return "pag{" +
                    "pageUrl='" + pageUrl + '\'' +
                    ", defaultJum=" + defaultJum +
                    ", link=" + link +
                    ", oriIndx=" + oriIndx +
                    ", linkJum=" + linkJum +
                    ", totalPt=" + totalPt +
                    '}';
        }
    }

    ArrayList findLink(String page){
        ArrayList<String> arl = new ArrayList<>();
        Pattern p = Pattern.compile("<a href=\"(\\S+)\">");
        Matcher m = p.matcher(page);
        while(m.find()){
            arl.add(m.group(1));
        }
        return arl;
    }

    int calDefulatJum(String page, String word){
        int cnt =0;
        page = page.split("<body")[1].replaceAll("[0-9]"," ");
        Pattern p = Pattern.compile("\\b"+word.toLowerCase()+"\\b");
        Matcher m = p.matcher(page.toLowerCase());
        while(m.find()) cnt++;
        return cnt;
    }

    String findUrl(String page){
        Pattern p = Pattern.compile("<meta property=\"og:url\" content=\"(\\S+)\"/>");
        Matcher m = p.matcher(page);
        if(m.find()){
            return m.group(1);
        }
        return "";
    }

    public int solution(String word, String[] pages) {

        pag[] p = new pag[pages.length];

        for (int i = 0; i < pages.length ; i++) {
            String page = pages[i];

            pag a = new pag();
            a.defaultJum = calDefulatJum(page,word);
            a.pageUrl = findUrl(page);
            a.link = findLink(page);
            a.oriIndx = i;

            p[i] = a;
        }

        int answer = 0;
        double maxPt = 0;

        for (int i = 0; i < p.length; i++) {
            pag cur = p[i];
            if(cur.link.size() != 0 ) {
                for (int j = 0; j < p.length; j++) {
                    pag nxt = p[j];
                    if(cur.link.contains(nxt.pageUrl)){
                        nxt.linkJum += (cur.defaultJum / cur.link.size());
                    }
                }
            }
        }

        for (int i = 0; i < p.length; i++) {
            pag cur = p[i];
            cur.totalPt = cur.linkJum + cur.defaultJum;
            if(cur.totalPt > maxPt ) {
                maxPt = cur.totalPt;
                answer = cur.oriIndx;
            }
            System.out.println("cur.toString() = " + cur.toString());
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"}));
        System.out.println(s.solution("blind",new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
    }
}