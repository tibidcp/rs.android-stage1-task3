package subtask2

class Combinator {
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]
        for (k in 1 until n) {
            if (combinationCount(n, k).toInt() == m)
                return k
        }
        return null
    }

    private fun combinationCount(n: Int, k: Int) =
        factorial(n) / (factorial(n - k) * factorial(k))

    private fun factorial(num: Int) = (1..num.toLong()).reduce(Long::times)
}
