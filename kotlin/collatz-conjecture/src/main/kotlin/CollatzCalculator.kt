object CollatzCalculator {
    fun computeStepCount(i: Int): Int {
        tailrec fun computeIt(i: Int, count: Int): Int {
            if (i == 1) {
                return count
            }
            return computeIt(when {
                i divisibleBy 2 -> 3 * i + 1
                else -> i / 2
            }, count + 1)
        }

        require(i > 0) {
            "Only natural numbers are allowed"
        }

        return computeIt(i, 0)
    }

    private infix fun Int.divisibleBy(i: Int) = rem(i) != 0

}