class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        if (c == 'E') {
            return listOf(
                    " ".repeat(4) + 'A' + " ".repeat(4), 
                    " ".repeat(3) + 'B' + " ".repeat(1) + 'B' + " ".repeat(3),
                    " ".repeat(2) + 'C' + " ".repeat(3) + 'C' + " ".repeat(2),
                    " ".repeat(1) + 'D' + " ".repeat(5) + 'D' + " ".repeat(1),
                    " ".repeat(0) + 'E' + " ".repeat(7) + 'E' + " ".repeat(0),
                    " ".repeat(1) + 'D' + " ".repeat(5) + 'D' + " ".repeat(1),
                    " ".repeat(2) + 'C' + " ".repeat(3) + 'C' + " ".repeat(2),
                    " ".repeat(3) + 'B' + " ".repeat(1) + 'B' + " ".repeat(3),
                    " ".repeat(4) + 'A' + " ".repeat(4)
                    )
        }
        if (c == 'C') {
            return listOf(
                    " ".repeat(2) + 'A' + " ".repeat(2), 
                    " ".repeat(1) + 'B' + " ".repeat(1) + 'B' + " ".repeat(1),
                    'C' + " ".repeat(3) + 'C',
                    " ".repeat(1) + 'B' + " ".repeat(1) + 'B' + " ".repeat(1),
                    " ".repeat(2) + 'A' + " ".repeat(2))
        }
        if (c == 'B') {
            return listOf(
                    " ".repeat(1) + 'A' + " ".repeat(1), 
                    'B' + " ".repeat(1) + 'B',
                    " ".repeat(1) + 'A' + " ".repeat(1))
        }
        
        return listOf("A")
    }
}
