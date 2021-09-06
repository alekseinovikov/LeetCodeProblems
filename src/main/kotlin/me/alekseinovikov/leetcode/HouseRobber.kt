package me.alekseinovikov.leetcode

//https://leetcode.com/problems/house-robber/
class HouseRobber {
    fun rob(nums: IntArray): Int {
        if (nums.size <= 2) return nums.maxOrNull() ?: 0

        val result = intArrayOf(0)

        robRecursively(2, nums, nums[0], result)
        robRecursively(1, nums, 0, result)

        return result[0]
    }

    private fun robRecursively(
        pointer: Int,
        arr: IntArray,
        sum: Int,
        result: IntArray
    ) {
        if (pointer > arr.lastIndex) {
            if (result[0] < sum) {
                result[0] = sum
            }
            println("Current result is ${result.contentToString()} and pointer is $pointer")
            return
        }

        if (pointer == arr.lastIndex) {
            val preResult = sum + arr[pointer]
            if (result[0] < preResult) {
                result[0] = preResult
            }
            println("Current result is ${result.contentToString()} and pointer is $pointer")
            return
        }

        robRecursively(pointer + 2, arr, sum + arr[pointer], result)
        robRecursively(pointer + 1, arr, sum, result)
        robRecursively(pointer + 2, arr, sum, result)
    }
}