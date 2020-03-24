package com.hf;

import java.util.Arrays;

/**使数组唯一的最小增量
 * @Description
 * @auther Administrator
 * @create 2020-03-22 下午 3:43
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            while (A[i] <= A[i - 1]){
                count ++ ;
                A[i] = A[i] + 1;
            }
        }
        return count;
    }

    //官方方法
    public int minIncrementForUnique1(int[] A) {
        Arrays.sort(A);
        int ans = 0, taken = 0;
        for (int i = 1; i < A.length; ++i) {
            if (A[i-1] == A[i]) {
                taken++;
                ans -= A[i];
            } else {
                int give = Math.min(taken, A[i] - A[i-1] - 1);
                ans += give * (give + 1) / 2 + give * A[i-1];
                taken -= give;
            }
        }

        if (A.length > 0) {
            ans += taken * (taken + 1) / 2 + taken * A[A.length - 1];
        }

        return ans;
    }

}
