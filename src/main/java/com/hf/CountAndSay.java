package com.hf;

/**
 * @Description
 * @auther Administrator
 * @create 2020-02-11 下午 6:58
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n ; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0,ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if(c == currentChar){
                    num++;
                }
                else{
                    ans.append((char)('0'+num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char)('0'+num));
            ans.append(currentChar);

        }

        return ans.toString();
    }

    public static void main(String[] args) {
//        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
//        allocation1 = new byte[32000*1024];
//        allocation2 = new byte[8000*1024];
//        allocation3 = new byte[8000*1024];
//        allocation4 = new byte[1000*1024];
//        allocation5 = new byte[1000*1024];

        String s = "aa";
        String s2 = "aa" + "bb";
        String s1 = "aabb";
        System.out.println(s1 == s2);
    }


}
