class Chunk(private val value: String) {
    fun encode(): String {
        return value
                .toCharArray()
                .map { encode(it) }
                .joinToString("")
    }

    private fun encode(c: Char) = if (!c.isLetter()) c else 'z' - (c - 'a')
}