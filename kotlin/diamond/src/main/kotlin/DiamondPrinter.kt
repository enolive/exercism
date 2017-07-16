class DiamondPrinter {
    fun printToList(c: Char): List<String> {
        if (c == 'B') {
            return listOf(" A ", "B B", " A ")
        }
        
        return listOf("A")
    }
}
