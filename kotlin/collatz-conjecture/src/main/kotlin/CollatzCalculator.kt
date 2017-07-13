object CollatzCalculator {
    tailrec fun computeStepCount(i: Int, count: Int = 0): Int {
        require(i > 0) {
            "Only natural numbers are allowed"
        }
        
        if (i == 1) {
            return count
        }

        return computeStepCount(when {
            i divisibleBy 2 -> 3 * i + 1
            else -> i / 2
        }, count + 1)
    }

    private infix fun Int.divisibleBy(i: Int) = rem(i) != 0

}