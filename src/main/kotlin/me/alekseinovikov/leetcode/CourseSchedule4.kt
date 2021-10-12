package me.alekseinovikov.leetcode

class CourseSchedule4 {

    data class Course(
        val id: Int,
        val count: Int
    ) {
        val post: Array<Course?> = Array(count) { null }
    }

    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val allNodes = Array<Course?>(numCourses) { null }

        prerequisites.forEach { cur ->
            val postCurId = cur[1]
            val preCurId = cur[0]

            var pre = allNodes[preCurId]
            if (null == pre) {
                pre = Course(preCurId, numCourses)
                allNodes[preCurId] = pre
            }

            var post = allNodes[postCurId]
            if (post == null) {
                post = Course(postCurId, numCourses)
                allNodes[postCurId] = post
            }

            pre.post[postCurId] = post
        }

        val result = mutableListOf<Boolean>()
        queries.forEach { q ->
            val pre = q[0]
            val toFind = q[1]

            val preNode = allNodes[pre]
            if (preNode == null) {
                result.add(false)
            } else {
                result.add(traverse(preNode, toFind))
            }
        }

        return result
    }

    private fun traverse(currNode: Course, toFind: Int): Boolean {
        if (currNode.post[toFind] != null) {
            return true
        }

        return currNode.post.filterNotNull().any { traverse(it, toFind) }
    }

}