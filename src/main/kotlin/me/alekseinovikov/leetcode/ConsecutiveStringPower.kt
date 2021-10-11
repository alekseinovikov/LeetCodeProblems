package me.alekseinovikov.leetcode

class ConsecutiveStringPower {
    fun maxPower(s: String): Int {
        if (s.isEmpty()) return 0
        var letter = s[0]
        var result = 0
        var maxCount = 0
        s.forEach { pointer ->
            if(pointer == letter) {
                maxCount++
            } else {
                if(result < maxCount) {
                    result = maxCount
                }

                maxCount = 1
                letter = pointer
            }
        }

        return if(result > maxCount) result else maxCount
    }
}