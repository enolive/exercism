class Chunk(private val value: String) {
    fun transcode(): String {
        return value
                .toCharArray()
                .map { transcode(it) }
                .joinToString("")
    }

    private fun transcode(c: Char) = if (!c.isLetter()) c else 'z' - (c - 'a')
}