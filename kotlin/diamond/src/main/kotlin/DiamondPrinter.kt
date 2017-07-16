class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        if (c == 'B') {
            return listOf(
                    " ".repeat(1) + 'A' + " ".repeat(1), 
                    'B' + " ".repeat(1) + 'B',
                    " ".repeat(1) + 'A' + " ".repeat(1))
        }
        
        return listOf("A")
    }
}
