class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        return (('A'..c) + (c - 1 downTo 'A'))
                .map { line(it, c) }
    }

    private fun line(current: Char, limit: Char): String {
        val numberOfEdgeSpaces = limit - current
        val numberOfMiddleSpaces = 2 * (current - 'A') - 1
        val edges = " ".repeat(numberOfEdgeSpaces)
        if (numberOfMiddleSpaces < 0) {
            return edges + current + edges
        }

        val middle = " ".repeat(numberOfMiddleSpaces)
        return edges +
                current +
                middle +
                current +
                edges
    }
}
