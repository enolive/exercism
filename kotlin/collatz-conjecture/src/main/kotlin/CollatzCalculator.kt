object CollatzCalculator {
    fun computeStepCount(i: Int): Int {
        require(i > 0) {
            "Only natural numbers are allowed"
        }

        tailrec fun computeIt(i: Int, count: Int): Int {
            return when (i) {
                1 -> count
                else -> computeIt(i.next(), count + 1)
            }
        }

        return computeIt(i, 0)
    }
    
    private fun Int.next(): Int {
        return when {
            isEven() -> this / 2
            else -> 3 * this + 1
        }
    }

    private fun Int.isEven() = this.rem(2) == 0
}