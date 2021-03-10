package com.oasm.test;

public class BigIntMultiply {
    public static String multiply(String num1, String num2) {

        //将字符串转为int数组
        int[] num1Arr = string2IntArray(num1);
        int[] num2Arr = string2IntArray(num2);

        //保存结果
        int[] result = new int[num1Arr.length + num2Arr.length];
        int m =-1;
        double d = 10.0;

        //按位依次相乘，并且存入数组对于的位置
        for (int i = 0; i < num1Arr.length; i++) {
            for (int j = 0; j < num2Arr.length; j++) {
                result[i + j + 1] += num1Arr[i] * num2Arr[j];
            }
        }

        //处理进位
        for (int i = result.length - 1 ; i > 0; i--) {
            if(result[i] > 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }

        //将结果转为String
        return intArray2String(result);
    }

    private static int[] string2IntArray(String s) {
        int[] res = new int[s.length()];

        int i = 0;
        for(char c: s.toCharArray()) {
            res[i++] = c - '0';
        }
        return res;
    }

    private static String intArray2String(int[] arr) {
        StringBuilder sb = new StringBuilder();
        //如果首位是0，将0去掉
        if(arr[0] != 0) {
            sb.append(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("12","13"));
    }
}
