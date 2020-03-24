package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-23 下午 9:44
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int s = 0;
        for(int i = a.length() - 1,j = b.length() - 1;i >= 0 || j >= 0;i--,j--){
            int sum = s;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            s = sum / 2;
        }
        if(s == 1){
            sb.append(s);
        }
        return sb.reverse().toString();
    }

}
