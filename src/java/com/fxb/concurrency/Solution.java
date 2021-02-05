package com.fxb.concurrency;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, Integer> map = slove(str);
        for(String key : map.keySet()){
            System.out.print(key + map.get(key));
        }
        sc.close();
    }

    private static Map<String, Integer> slove(String str) {
        char[] arr = str.toCharArray();
        Map<String, Integer> nMap = new TreeMap<>();
        for(int i = 0; i < arr.length; ){
            //大写，元素开头
            if(Character.isUpperCase(arr[i])){
                //获取元素名称
                int first = i++;
                while(i < arr.length && Character.isLowerCase(arr[i])){
                    //大写字母后面接的小写字母属于同一个元素
                    i++;
                }
                String name = str.substring(first, i);
                //获取数量
                int num = 0;
                while(i < arr.length && Character.isDigit(arr[i])){
                    num = (num << 1) + (arr[i] - '0');
                    i++;
                }
                num = num == 0 ? 1 : num;
                //将元素放入结果集
                nMap.put(name, num);
            }else if (arr[i] == '(' || arr[i] == '['){
                //获取字符串中与该括号匹配的数组下标
                int rp = getMatchIndex(arr, i);
                //截取括号内容
                String subStr = str.substring(i+1, rp);
                i = rp + 1;
                //递归处理
                Map<String, Integer> tmpMap = slove(subStr);
                int num = 0;
                while(i < arr.length && Character.isDigit(arr[i])){
                    num = (num<<1) + (arr[i] - '0');
                    i++;
                }
                num = num == 0 ? 1 : num;
                for(String key : tmpMap.keySet()) {//将括号内子串的处理结果添加到当前串的map中
                    nMap.put(key, nMap.getOrDefault(key, 0) + tmpMap.get(key) * num);
                }
            }
        }
        return nMap;
    }

    private static int getMatchIndex(char[] arr, int i) {
        char c = arr[i];
        char op = c == '(' ? ')' : ']';
        int flag = 1;
        for(int j = i+1; j < arr.length; j++){
            if(arr[j] == c){
                flag++;
            }else if(arr[j] == op){
                flag--;
            }
            if(flag == 0){
                return j;
            }
        }
        return -1;
    }

}
