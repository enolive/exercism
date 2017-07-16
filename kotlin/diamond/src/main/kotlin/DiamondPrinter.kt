class DiamondPrinter {
    fun printToList(limit: Char): List<String> {
        val upperHalf = ('A'..limit).map { line(it, limit) }
        return upperHalf + upperHalf.reversed().drop(1)
    }

    private fun line(current: Char, limit: Char): String {
        val lineHalf = edgeSpaces(limit, current) + current + middleSpacesHalf(current)
        return lineHalf + lineHalf.reversed().drop(1)
    }

    private fun edgeSpaces(limit: Char, current: Char) = " ".repeat(limit - current)

    private fun middleSpacesHalf(current: Char): String {
        val totalSpaces = 2 * (current - 'A') - 1
        val middle = if (totalSpaces <= 0) {
            ""
        } else {
            val addOneSpaceForLaterDrop = 1
            " ".repeat(totalSpaces / 2 + addOneSpaceForLaterDrop)
        }
        return middle
    }
}
