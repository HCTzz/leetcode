package com.hf;

import java.util.Arrays;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-06 下午 1:32
 */
public class FindMedianSortedArrays {


//    public static void main(String[] args) {
//        int[] a = {1,3,12,23};
//        int[] b = {1,32,4,2,6};
//        findMedianSortedArrays(a,b);
//    }

//    public static int findMedianSortedArrays(int[] a,int[] b){
//        if(a.length < 1 || b.length < 1){
//            return -1;
//        }
//        if(a.length == 1 && a.length == 1){
//            return (a[0] + b [0])/2 ;
//        }
//        int[] c = mergeTwoArrays(a,b);
//        sort(c,0,c.length - 1);
//        return c[0];
//    }

    public static void sort(int[] a,int L,int R){
        if(L == R) {
            return;
        }
        int mid = (R + L) / 2;
        sort(a,L,mid);
        sort(a,mid + 1,R);
        merge(a,L,mid,R);
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
    }

    public static void merge(int[] arr,int L,int mid,int R){
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while(p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static int[] mergeTwoArrays(int[] a,int[] b){
        int[] c = new int[a.length + b.length];
        for (int i = 0 ; i < a.length; i++){
            c[i] = a[i];
        }
        for (int i = 0 ; i < b.length; i++){
            c[a.length + i] = b[i];
        }
        return c;
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2,4,72,543,655};
        int[] nums2 = {2,3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
