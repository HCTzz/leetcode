package com.hf;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 * @auther Administrator
 * @create 2020-02-06 下午 8:16
 */
public class MergeSort {

    public static void mergesort(int[] arr,int L,int R){
        if(L == R){
            return ;
        }
        int mid = (R + L) / 2;
        mergesort(arr,L,mid);
        mergesort(arr,mid + 1,R);
        merge(arr,L,mid,R);
//        Arrays.stream(arr).forEach(q -> {
//            System.out.print(q + ".");
//        });
    }
    public static void merge(int[] arr,int L,int mid,int R){
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while(p1 <= mid && p2 <= R){
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1 <= mid){
            temp[i++] = arr[p1++];
        }
        while(p2 <= R){
            temp[i++] = arr[p2++];
        }
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,21,12,543,2,1};
        mergesort(arr,0,arr.length - 1);
    }
}
