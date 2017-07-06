class Rule(pair: Pair<Int, String>) {
    val result = pair.second
    private val denominator = pair.first

    fun appliesTo(input: Int): Boolean {
        return input.isDivisibleBy(denominator)
    }
    
    private fun Int.isDivisibleBy(denominator: Int) = this % denominator == 0
}