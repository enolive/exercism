class DiamondPrinter {
    fun printToList(limit: Char): List<String> {
        val upperHalf = ('A'..limit).map { line(it, limit) }
        return upperHalf + upperHalf.reversed().drop(1)
    }

    private fun line(current: Char, limit: Char): String {
        val numberOfEdgeSpaces = limit - current
        val numberOfMiddleSpaces = 2 * (current - 'A') - 1
        val edges = " ".repeat(numberOfEdgeSpaces)
        
        if (numberOfMiddleSpaces <= 0) {
            val half = edges + current
            return half + half.reversed().drop(1)
        }

        val middle = " ".repeat(numberOfMiddleSpaces / 2 + 1)
        val lineHalf = edges + current + middle
        return lineHalf + lineHalf.reversed().drop(1)
    }
}
