package com.mktb.nobug.p4;

public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int m = nums1.length;
//        int n = nums2.length;
//        int f1 = 0;
//        int f2 = 0;
//
//        if ((m + n) % 2 != 0) {
//            while (f1 != m && f2 != n) {
//                if (nums1[(f1 + m) / 2] > nums2[(f2 + n) / 2]) {
//                    m = (f1 + m) / 2;
//                    f2 = (f2 + n) / 2;
//                } else {
//                    f1 = (f1 + m) / 2;
//                    n = (f2 + n) / 2;
//                }
//            }
//
//            return f1 == m ? nums2[(f2 + n) / 2] : nums1[(f1 + m) / 2];
//        } else {
//            while (f1 != m && f2 != n) {
//                if (nums1[(f1 + m) / 2] > nums2[(f2 + n) / 2]) {
//                    m = (f1 + m) / 2;
//                    f2 = (f2 + n) / 2;
//                } else {
//                    f1 = (f1 + m) / 2;
//                    n = (f2 + n) / 2;
//                }
//            }
//
//            if (f1 == m && f2 == n) {
//                return (nums1[f1] + nums2[f2]) / 2.0;
//            } else if (f1 == m) {
//                if (nums1[f1] < nums2[(f2 + n) / 2]) {
//                    return nums2[];
//                }
//            }
//        }
//    }

    public int getKthElement(int[] nums1, int f1, int[] nums2, int f2, int k) {
        if (f1 > nums1.length - 1) {
            return nums2[f2 + k - 1];
        }
        if (f2 > nums2.length - 1) {
            return nums1[f1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[f1], nums2[f2]);
        }

        int mid1 = (f1 + k / 2 - 1 < nums1.length) ? nums1[f1 + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (f2 + k / 2 - 1 < nums2.length) ? nums2[f2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (mid1 <= mid2) {
            return getKthElement(nums1, f1 + k / 2, nums2, f2, k - k / 2);
        } else {
            return getKthElement(nums1, f1, nums2, f2 + k / 2, k - k / 2);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m + n) % 2 == 0) {
            return (getKthElement(nums1, 0, nums2, 0, (m + n) / 2) + getKthElement(nums1, 0, nums2, 0, (m + n) / 2 + 1)) / 2.0;
        } else {
            return getKthElement(nums1, 0, nums2, 0, (m + n) / 2 + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] n1 = {1, 2};
        int[] n2 = {3, 4};

        System.out.println(solution.findMedianSortedArrays(n1, n2));
    }
}
