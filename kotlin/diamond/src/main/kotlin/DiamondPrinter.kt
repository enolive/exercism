class DiamondPrinter {
    fun printToList(limit: Char): List<String> {
        return range(limit).map { line(it, limit) }
    }

    private fun range(limit: Char) = (('A'..limit) + (limit - 1 downTo 'A'))

    private fun line(current: Char, limit: Char): String {
        val numberOfEdgeSpaces = limit - current
        val numberOfMiddleSpaces = 2 * (current - 'A') - 1
        val edges = " ".repeat(numberOfEdgeSpaces)
        if (numberOfMiddleSpaces < 0) {
            return edges + current + edges
        }

        val middle = " ".repeat(numberOfMiddleSpaces)
        return edges + current + middle + current + edges
    }
}
