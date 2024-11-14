package com.stack;

import java.util.Stack;

class StockSpan {
    public int[] calculateSpan(int[] prices) {
        int[] span = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i])
                stack.pop();
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        StockSpan solution = new StockSpan();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = solution.calculateSpan(prices);
        for (int r : result) System.out.print(r + " "); // 1 1 1 2 1 4 6
    }
}
