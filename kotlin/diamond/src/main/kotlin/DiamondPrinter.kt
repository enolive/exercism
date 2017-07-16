class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        return (('A'..c) + (c - 1 downTo 'A'))
                .map { line(it, c) }
    }

    private fun line(current: Char, limit: Char): String {
        val edges = " ".repeat(limit - current)
        val numberOfMiddleSpaces = 2 * (current - 'A') - 1
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
