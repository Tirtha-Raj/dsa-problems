package com.dsa.week1;

public class BuyAndSellStockLC121 {

	public static void main(String[] args) {
		
//		Input: prices = [7,1,5,3,6,4]
//				Output: 5
//				Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//				Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
		
		System.out.println(BuyAndSellStockLC121.maxProfit(new int[] {7,1,5,3,6,4}));
	}

	public static int maxProfit(int[] prices) {
		 int left = 0,right=0,maxProfit =0;
	       while(right < prices.length){
	        if(prices[left] > prices[right]){
	            left= right;
	        } else{
	            maxProfit = Math.max(maxProfit, prices[right] -prices[left]);
	        }
	        right++;
	       } 
	       return maxProfit;
	}
}
