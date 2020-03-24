package com.hf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**169、多数元素
 * @Description
 * @auther Administrator
 * @create 2020-03-13 上午 9:19
 */
public class MajorityElement {


    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        Map<String, Long> map = Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.groupingBy(String::intern,Collectors.counting()));
        int a = 0;
        for(Map.Entry<String, Long> en : map.entrySet()){
            if(en.getValue() > mid){
                return Integer.parseInt(en.getKey());
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] t = {3,2,3};
        System.out.println(majorityElement(t));
    }
}
