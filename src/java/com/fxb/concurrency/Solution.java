package com.fxb.concurrency;

import java.util.*;

class Solution {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        Map<String, Integer> map = slove(str);
//        for(String key : map.keySet()){
//            System.out.print(key + map.get(key));
//        }
//        sc.close();
        new Solution().crackSafe(3, 2);
    }
    TreeSet<String> visited;
    StringBuilder res;
    public  String crackSafe(int n, int k) {
        if(n == 1 && k == 1) return "0";
        visited = new TreeSet<>();
        res = new StringBuilder();
        //从顶点开始
        String start = String.join("", Collections.nCopies(n - 1, "0"));
        findEuler(start,  k);
        res.append(start);
        return res.toString();
    }

    private void findEuler(String curv, int k) {
        for (int i = 0; i < k; i++) {
            String nextv = curv + i;
            if(!visited.contains(nextv)){
                visited.add(nextv);
                findEuler(nextv.substring(1), k);
                res.append(i);
            }
        }
    }

    public static  String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        List<Integer> ans = new ArrayList<>();

        //每位的阶乘个数
        int[] factorials = new int[n+1];
        factorials[0] = 1;
        for(int i = 1, fact = 1; i <= n; i++){
            ans.add(i);
            fact *= i;
            factorials[i] = fact;
        }
        //根据 k / (n-1)! = num , num等于当前位数
        k -= 1;
        for(int i = n-1; i >= 0; i--){
            int idx = k / factorials[i];
            res.append(ans.remove(idx));
            k -= idx * factorials[i];
        }
        return res.toString();
    }
}


/*
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
*/