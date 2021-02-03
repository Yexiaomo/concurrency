package com.fxb.concurrency;
import java.util.*;
import java.util.stream.Collectors;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        String[] data = input.substring(1,input.length()-1).split(",");
        System.out.println(help(data));
        sc.close();
    }

    private static String help(String[] data) {

        Arrays.sort(data, (x,y) -> (y+x).compareTo(x+y));
        return Arrays.stream(data).collect(Collectors.joining(""));
    }

//    private static String analyis(String s) {
//        if(s.length() < 1) return "";
//        HashMap<String, Integer> map = new HashMap<>();
//        LinkedList<String> stack = new LinkedList<>();
//        for(int i = 0; i < s.length(); i++){
//            //找到一个元素名称
//            int j = i;
//            while(s.charAt(j) != )
//        }
//    }

}
