package Programmers_1st.Level1.핸드폰번호가리기;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] tmp = phone_number.toCharArray();
        for(int i=0; i<phone_number.length()-4; i++){
                answer += "*";
        }
        for (int i = phone_number.length()-4; i < phone_number.length(); i++) {
            answer += tmp[i];
        }
        return answer;
    }
}
// string에서 char로 변신시킨후, index로 접근가능
// -> string.toCharArray() 로 하는거임

//    public String solution(String phone_number) {
//        char[] ch = phone_number.toCharArray();
//        for(int i = 0; i < ch.length - 4; i ++){
//            ch[i] = '*';
//        }
//        return String.valueOf(ch);
//    }