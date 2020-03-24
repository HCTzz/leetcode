package com.hf;

import java.util.Arrays;

public class MinStack {

    private int[] table;

    private int size = 0;

    private int count = 0;

    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        table = new int[4];
        size = 4;
    }

    public void push(int x) {
        if(size == count + 1){
            resizeTable();
        }
        if(min > x ){
            min = x;
        }
        table[count] = x;
        count ++ ;
    }

    private void resizeTable(){
        size = size * 2;
        int[] temp = new int[size];
        System.arraycopy(table,0,temp,0,count);
        table = temp;
    }

    public void pop() {
        if(count > 0){
            count --;
        }
        min = table[0];
        for (int i = 1; i < count; i++) {
            if(min > table[i]){
                min = table[i];
            }
        }
        if(count == 0){
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        if(count == 0){
            return 0;
        }
        return table[count - 1];
    }

    public int getMin() {
        return min;
    }

    public void ys(){
        Arrays.stream(table).forEach(i -> {
            System.out.print(i + " ---  ");
        });
        System.out.print(count);
        System.out.println();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.ys();
        minStack.push(2147483646);
        minStack.ys();
        minStack.push(2147483647);
        minStack.ys();
        minStack.top();
        minStack.ys();
        minStack.pop();//删除
        minStack.ys();
        minStack.getMin();
        minStack.ys();
        minStack.pop();//
        minStack.ys();
        minStack.getMin();
        minStack.ys();
        minStack.pop();
        minStack.ys();
        minStack.push(2147483647);
        minStack.ys();
        minStack.top();
        minStack.ys();
        minStack.getMin();
        minStack.ys();
        minStack.push(-2147483648);
        minStack.ys();
        minStack.top();
        minStack.ys();
        minStack.getMin();
        minStack.pop();;
        minStack.getMin();
        minStack.ys();
    }

}
