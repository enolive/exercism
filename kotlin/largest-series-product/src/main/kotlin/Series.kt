class Series(input: String) {
    private val digits = input.map {
        require(it.isDigit())
        it.toString().toLong()
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0)
        require(span <= digits.size)
        val max = (1..digits.size - span)
                .map { numberSequence(it, span).reduce(product()) }
                .max()
        return max ?: 1
    }

    private fun product() = { a: Long, b: Long -> a * b }

    private fun numberSequence(start: Int, length: Int) =
            digits.slice(start until start + length)

}
