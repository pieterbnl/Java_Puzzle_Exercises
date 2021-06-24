package com.pbe.Arrays;

// LEETCODE.COM: Remove Duplicates from Sorted Array
// Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
// The relative order of the elements should be kept the same.
// Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
// More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
// It does not matter what you leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.
// Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
// The judge will test your solution with the following code:
// int[] nums = [...]; // Input array
// int[] expectedNums = [...]; // The expected answer with correct length
// int k = removeDuplicates(nums); // Calls your implementation
//
// assert k == expectedNums.length;
// for (int i = 0; i < k; i++) {
// assert nums[i] == expectedNums[i];
// }
// If all assertions pass, then your solution will be accepted.

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        // Set starting values
        int[] nums = { 1, 1, 2, 3, 3, 4 }; // Input
        int[] expectedNums = { 1, 2, 3, 4 }; // Expect answer with correct length

        // Run method and get results
        int k = removeDuplicates(nums);
        System.out.println("nums length: " + k);
        System.out.print("nums contents: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

        // Test results with assertions
        assert k == expectedNums.length : "expected length";

        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i] : "show me";
        }
    }

    // Method to remove duplicates from array
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // System.out.println("check if nums["+j+"] (" + nums[j] +") != nums["+i+"] (" + nums[i] +")");
            if (nums[j] != nums[i]) {
                i++;
                // System.out.println("set nums[" + i + "] (" + nums[i] +") equal to nums[" + j + "] (" + nums[j] +")");
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}