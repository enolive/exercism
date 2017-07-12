class Series(input: String) {
    private val digits = input.map {
        require(it.isDigit())
        it.toString().toLong()
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0)
        require(span <= digits.size)
        val max = (1..digits.size - span)
                .map { product(it, span) }
                .max()
        return max ?: 1
    }

    private fun product(index: Int, length: Int) =
            digits.slice(index until index + length)
                    .reduce { product, number -> product * number }

}
