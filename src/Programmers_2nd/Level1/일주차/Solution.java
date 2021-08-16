package Programmers_2nd.Level1.일주차;

class Solution {
    public long solution(int price, int money, int count) {
        long cost =  count * (count + 1 ) / 2;
        return (double)money / (double) price- cost < 0 ?  price * cost - money : 0;
    }
}