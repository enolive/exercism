object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val sanitizedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
        return Chunks.of(sanitizedInput).withSize(5)
                .map { encodeChunk(it) }
                .joinToString(" ")
    }

    private fun encodeChunk(chunk: String): String {
        return chunk
                .toCharArray()
                .map { encode(it) }
                .joinToString("")
    }

    private fun encode(c: Char) = if (!c.isLetter()) c else 'z' - (c - 'a')
}


