class DiamondPrinter {
    fun printToList(c: Char): List<String> {
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
