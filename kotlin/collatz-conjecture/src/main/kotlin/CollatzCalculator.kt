object CollatzCalculator {
    fun computeStepCount(i: Int): Int {
        tailrec fun computeIt(i: Int, count: Int): Int {
            if (i == 1) {
                return count
            }
            return computeIt(when {
                i.isEven() -> i / 2
                else -> 3 * i + 1
            }, count + 1)
        }

        require(i > 0) {
            "Only natural numbers are allowed"
        }

        return computeIt(i, 0)
    }
    
    private fun Int.isEven() = this.rem(2) == 0
}