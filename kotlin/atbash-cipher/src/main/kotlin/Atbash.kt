object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val sanitizedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
        return sanitizedInput.splitIntoChunksOf(5)
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

    private fun String.splitIntoChunksOf(chunkSize: Int): List<String> {
        val numberOfChunks = Math.ceil(length.toDouble() / chunkSize).toInt()
        return (0 until numberOfChunks).map { getChunk(it, chunkSize) }
    }

    private fun String.getChunk(indexOfChunk: Int, chunkSize: Int): String {
        val startIndex = indexOfChunk * chunkSize
        val endIndex = startIndex + chunkSize
        return substringOrRest(endIndex, startIndex)
    }

    private fun String.substringOrRest(endIndex: Int, startIndex: Int) 
            = if (endIndex >= length) substring(startIndex) else substring(startIndex, endIndex)
}

