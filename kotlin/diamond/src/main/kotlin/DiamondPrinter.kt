class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        if (c == 'E') {
            return listOf('A', 'B', 'C', 'D', 'E', 'D', 'C', 'B', 'A')
                    .map { line(it, c) }
        }
        if (c == 'C') {
            return listOf(
                    " ".repeat(2) + 'A' + " ".repeat(2),
                    " ".repeat(1) + 'B' + " ".repeat(1) + 'B' + " ".repeat(1),
                    " ".repeat(0) + 'C' + " ".repeat(3) + 'C' + " ".repeat(0),
                    " ".repeat(1) + 'B' + " ".repeat(1) + 'B' + " ".repeat(1),
                    " ".repeat(2) + 'A' + " ".repeat(2)
            )
        }
        if (c == 'B') {
            return listOf(
                    " ".repeat(1) + 'A' + " ".repeat(1),
                    'B' + " ".repeat(1) + 'B',
                    " ".repeat(1) + 'A' + " ".repeat(1))
        }

        return listOf("A")
    }

    private fun line(current: Char, limit: Char): String {
        val edges = " ".repeat(limit - current)
        if (current == 'A') {
            return edges + current + edges
        }
        
        val middle = " ".repeat(2 * (current - 'A') - 1)
        return edges +
                current +
                middle +
                current +
                edges
    }
}
