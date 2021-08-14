package Study.weeklychallenge.first;

class Solution {
    public long solution(int price, int money, int count) {

        long cost =  count * (count +1 ) / 2;

        return cost - money/price > 0 ? cost * price - money : 0 ;
    }
}