class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        val max = input.indices
                .filter { it <= input.length - span }
                .map { numberSequence(it, span).reduce(multiply()) }
                .max()
        return max!!
    }

    private fun multiply() = { a: Long, b: Long -> a * b }

    private fun numberSequence(start: Int, length: Int) =
            sequenceOf(input[start], input[start + 1])
                    .map { it.toString().toLong() }

}
