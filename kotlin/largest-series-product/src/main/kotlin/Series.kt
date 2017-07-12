class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        val max = input.indices
                .filter { it < input.length - 1 }
                .map { Pair(input[it], input[it + 1]) }
                .map { it.toLong() }
                .map { it.first * it.second }
                .max()
        return max!!
    }

}

private fun Pair<Char, Char>.toLong(): Pair<Long, Long> {
    return Pair(this.first.toString().toLong(), this.second.toString().toLong())
}
