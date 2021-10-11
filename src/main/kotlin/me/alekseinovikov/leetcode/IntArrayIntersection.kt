package me.alekseinovikov.leetcode

class IntArrayIntersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val result = mutableSetOf<Int>()

        nums1.forEach { n1 ->
            nums2.forEach { n2 ->
                if(n1 == n2) result.add(n1)
            }
        }

        return result.toIntArray()
    }
}