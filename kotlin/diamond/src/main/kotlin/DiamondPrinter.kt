class DiamondPrinter {
    fun printToList(limit: Char): List<String> {
        val upperHalf = ('A'..limit).map { line(it, limit) }
        return upperHalf + upperHalf.reversed().drop(1)
    }

    private fun line(current: Char, limit: Char): String {
        val numberOfMiddleSpaces = 2 * (current - 'A') - 1
        val edges = " ".repeat(limit - current)
        val middle = if (numberOfMiddleSpaces > 0) " ".repeat(numberOfMiddleSpaces / 2 + 1) else ""
        val lineHalf = edges + current + middle
        return lineHalf + lineHalf.reversed().drop(1)
    }
}
