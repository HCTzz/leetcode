package com.hf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-27 下午 4:37
 */
public class Generate {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowsList = new ArrayList<List<Integer>>(numRows);
        List<Integer>  tempList = null;
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i+1);
            for (int j = 0; j <= i; j++) {
                if(i < 3 || j == 0 || j == i){
                    list.add(1);
                }else{
                    list.add(tempList.get(j-1) + tempList.get(j));
                }
            }
            tempList = list;
            rowsList.add(list);
        }
        return rowsList;
    }

    //动态规划
    public static List<List<Integer>> generate1(int nums){
        List<List<Integer>> list = new ArrayList<>();
        if(nums == 0){
            return list;
        }
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i = 1;i < nums ; i++){
            List<Integer> addList = new ArrayList<Integer>();
            addList.add(1);
            List<Integer> tempList = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                addList.add(tempList.get(j-1    ) + tempList.get(j));
            }
            addList.add(1);
            list.add(addList);
        }
        return list;
    }

    public static void main(String[] args) {
        ExecutorService runserver = new ThreadPoolExecutor(20, 100, 2, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(1));
        System.out.println(generate(5).size());
    }

}
