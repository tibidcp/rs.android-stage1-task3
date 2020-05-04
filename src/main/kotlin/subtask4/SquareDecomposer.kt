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

        try {
            val s = getSquares(maxList, number * number - first * first)
                .first { it.distinct().size == it.size }
            squares.addAll(s)
        } catch (ex: NoSuchElementException) {
            return null
        }
        squares.add(first)
        return squares.sorted().toTypedArray()
    }

    private fun getSquares(list: List<Int>, sum: Int): MutableList<MutableList<Int>> {
        val squares = mutableListOf<MutableList<Int>>()
        for (item in list) {
            for (i in 1..item) {
                val square = mutableListOf(i)
                var remainder = sum - i * i
                while (remainder != 0) {
                    val sqrt = sqrt(remainder.toDouble()).toInt()
                    remainder -= sqrt * sqrt
                    square.add(sqrt)
                }
                squares.add(square)
            }
        }
        return squares
    }
}
