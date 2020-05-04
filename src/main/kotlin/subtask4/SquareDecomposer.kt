package subtask4

import kotlin.math.sqrt

class SquareDecomposer {
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number <= 0) {
            return null
        }
        val first = number - 1
        var remainder = number * number - first * first
        val maxList = mutableListOf<Int>()
        val squares = mutableListOf<Int>()
        while (remainder != 0) {
            val sqrt = sqrt(remainder.toDouble()).toInt()
            remainder -= sqrt * sqrt
            maxList.add(sqrt)
        }
        val s = getSquares(maxList, number * number - first * first) ?: return null
        squares.addAll(s)
        squares.add(first)
        return squares.sorted().toTypedArray()
    }

    private fun getSquares(list: List<Int>, sum: Int): List<Int>? {
        for (item in list) {
            for (i in 1..item) {
                val square = mutableListOf(i)
                var remainder = sum - i * i
                while (remainder != 0) {
                    val sqrt = sqrt(remainder.toDouble()).toInt()
                    remainder -= sqrt * sqrt
                    square.add(sqrt)
                }
                if (square.distinct().size == square.size) {
                    return square
                }
            }
        }
        return null
    }
}
