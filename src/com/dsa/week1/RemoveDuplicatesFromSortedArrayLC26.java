package com.dsa.week1;

public class RemoveDuplicatesFromSortedArrayLC26 {
	public static void main(String[] args) {

//	Example 1:
//
//		Input: nums = [1,1,2]
//		Output: 2, nums = [1,2,_]
//		Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//		It does not matter what you leave beyond the returned k (hence they are underscores).

		System.out.println(RemoveDuplicatesFromSortedArrayLC26.removeDuplicates(new int[] { 0,0,1,1,1,2,2,3,3,4 }));
	}

	public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int k =1;
        for(int i =1 ; i< nums.length;i++){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
