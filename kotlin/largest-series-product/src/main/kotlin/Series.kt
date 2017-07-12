class Series(private val input: String) {
    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        val max = input.indices
                .filter { it <= input.length - span }
                .map { numberSequence(it, span).reduce(multiply()) }
                .max()
        return max ?: 1
    }

    private fun multiply() = { a: Long, b: Long -> a * b }

    private fun numberSequence(start: Int, length: Int) =
            input.indices
                    .filter { it >= start }
                    .take(length)
                    .map { input[it].toString().toLong() }

}
