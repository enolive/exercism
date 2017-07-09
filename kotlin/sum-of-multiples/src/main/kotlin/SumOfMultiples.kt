object SumOfMultiples {
    fun sum(quotients: Iterable<Int>, number: Int): Int {
        return (1..number - 1)
                .filter { n -> n.isMultipleOfAny(quotients) }
                .sum()
    }

    private fun Int.isMultipleOfAny(quotients: Iterable<Int>) = quotients.any { q -> isDivisibleBy(q) }

    private fun Int.isDivisibleBy(q: Int) = this % q == 0

}