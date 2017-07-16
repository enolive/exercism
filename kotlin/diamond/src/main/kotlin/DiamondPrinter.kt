class DiamondPrinter {
    fun printToList(max: Char): List<String> {
        val upperHalf = ('A'..max).map { line(it, max) }
        return upperHalf + upperHalf.reversed().drop(1)
    }

    private fun line(current: Char, max: Char): String {
        val lineHalf = edgeSpaces(current, max) + current + middleSpacesHalf(current)
        return lineHalf + lineHalf.reversed().drop(1)
    }

    private fun edgeSpaces(current: Char, max: Char) = " ".repeat(max - current)

    private fun middleSpacesHalf(current: Char) = " ".repeat(current - 'A')
}
