package com.hf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**杨辉三角 II 获取m行的数
 * @Description
 * @auther Administrator
 * @create 2020-02-28 上午 9:44
 */
public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }


    //Ck = Ck-1 * (N - k + 1) / K
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        long pre = 1;
        ans.add(1);
        for (int k = 1; k <= N; k++) {
            long cur = pre * (N - k + 1) / k;
            ans.add((int) cur);
            pre = cur;
        }
        return ans;
    }



}