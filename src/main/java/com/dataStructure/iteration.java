package com.dataStructure;

/**
 * @description: 斐波那契数列  递归   0, 1, 1, 2, 3, 5, 8, 13
 * @author: shangqj
 * @date: 2023/12/26
 * @version: 1.0
 */
public class iteration {
    public static void main(String[] args) {
        int fib = fib(8);
        System.out.println("fib = " + fib);
    }

    /**
     * 设斐波那契数列的第 𝑛 个数字为 𝑓(𝑛) ，易得两个结论。
     * ‧ 数列的前两个数字为 𝑓(1) = 0 和 𝑓(2) = 1 。
     * ‧ 数列中的每个数字是前两个数字的和，即 𝑓(𝑛) = 𝑓(𝑛 − 1) + 𝑓(𝑛 − 2) 。
     *
     * @param n 第n个
     * @return 返回第n个的数
     */
    static int fib(int n) {

        //终止条件 f(1)=0  f(2)=1
        if (n == 1 || n == 2) {
            return n - 1;
        }

        //递归调用 f(n)=f(n-1)+f(n-2)
        int res = fib(n - 1) + fib(n - 2);
        //返回结果 f(n)
        return res;


    }
}
