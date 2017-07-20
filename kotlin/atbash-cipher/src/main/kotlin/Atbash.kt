object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val chunkSize = 5
        val sanitizedInput = input.toLowerCase()
        val numberOfChunks = sanitizedInput.length / chunkSize
        return (0..numberOfChunks)
                .map { sanitizedInput.getChunk(it, chunkSize) }
                .map { encodeChunk(it) }
                .joinToString(" ")
    }

    private fun encodeChunk(chunk: String): String {
        return chunk
                .toCharArray()
                .map { encode(it) }
                .joinToString("")
    }

    private fun encode(c: Char) = 'z' - (c - 'a')

    fun String.getChunk(indexOfChunk: Int, chunkSize: Int): String {
        val startIndex = indexOfChunk * chunkSize
        val endIndex = startIndex + chunkSize
        return if (endIndex >= length) substring(startIndex) else substring(startIndex, endIndex)
    }
}

