package com.hf;

import java.util.Arrays;

public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] key = new int[k];
        System.arraycopy(arr,0,key,0,k);
        return key;
    }

}
