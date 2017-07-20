object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val chunkSize = 5
        val sanitizedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
        return sanitizedInput.splitIntoChunksOf(chunkSize)
                .map { encodeChunk(it) }
                .joinToString(" ")
    }

    private fun String.splitIntoChunksOf(chunkSize: Int): List<String> {
        val numberOfChunks = Math.ceil(length.toDouble() / chunkSize).toInt()
        val chunkify = chunkify(numberOfChunks, chunkSize)
        return chunkify
    }

    private fun encodeChunk(chunk: String): String {
        return chunk
                .toCharArray()
                .map { encode(it) }
                .joinToString("")
    }

    private fun encode(c: Char) = if (!c.isLetter()) c else 'z' - (c - 'a')

    private fun String.chunkify(numberOfChunks: Int, chunkSize: Int) =
            (0 until numberOfChunks).map { getChunk(it, chunkSize) }

    fun String.getChunk(indexOfChunk: Int, chunkSize: Int): String {
        val startIndex = indexOfChunk * chunkSize
        val endIndex = startIndex + chunkSize
        return if (endIndex >= length) substring(startIndex) else substring(startIndex, endIndex)
    }
}

