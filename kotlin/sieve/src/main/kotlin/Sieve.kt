
object Sieve {
    private val start = 2

    fun primesUpTo(limit: Int): List<Int> 
            = (start..limit).filter { it.isPrime() }

    private fun Int.isPrime(): Boolean =
            (start..highestPossiblePrime())
                    .none { isDivisibleBy(it) }

    private fun Int.highestPossiblePrime() = Math.sqrt(this.toDouble()).toInt()

    private fun Int.isDivisibleBy(it: Int) = this % it == 0
}


