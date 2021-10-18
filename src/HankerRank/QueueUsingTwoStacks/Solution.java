package HankerRank.QueueUsingTwoStacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int queryNum = Integer.parseInt(br.readLine());

        MyQueue<Integer> myQueue = new MyQueue<>();

        for (int i = 0; i < queryNum ; i++) {
            String input = br.readLine();
            if(input.length()==1){
                if(input.equals("2")){
                    myQueue.dequeue();
                } else {
                    System.out.println(myQueue.peek());
                }
            } else {
                String[] s = input.split(" ");
                int enqueNum = Integer.parseInt(s[1]);
                myQueue.enqueue(enqueNum);
            }
        }

        br.close();
    }
}

class MyQueue<T> {
    Stack<T> leftStack = new Stack<>();
    Stack<T> rightStack = new Stack<>();

    void enqueue(T item){
        leftStack.push(item);
    }

    T dequeue() {
        transferIfNeeded();
        return rightStack.pop();
    }

    T peek(){
        transferIfNeeded();
        return rightStack.peek();
    }

    private void transferIfNeeded() {
        if(rightStack.empty()){
            while(!leftStack.empty()){
                rightStack.push(leftStack.pop());
            }
        }
    }

}
