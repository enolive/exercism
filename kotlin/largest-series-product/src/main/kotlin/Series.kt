class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        val max = input.indices
                .filter { it < input.length - 1 }
                .map { sequenceOf(it) }
                .map { it.reduce { a, b -> a * b} }
                .max()
        return max!!
    }

    private fun sequenceOf(it: Int) = sequenceOf(input[it], input[it + 1]).map { it.toString().toLong() }

}
