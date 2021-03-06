object Chunks {
    fun of(input: String): ChunkBuilder {
        return ChunkBuilder(input)
    }

    class ChunkBuilder internal constructor(private val input: String) {
        fun withSize(size: Int): List<Chunk> {
            val numberOfChunks = Math.ceil(input.length.toDouble() / size).toInt()
            return (0 until numberOfChunks).map { Chunk(input.getChunk(it, size)) }
        }

        private fun String.getChunk(indexOfChunk: Int, chunkSize: Int): String {
            val startIndex = indexOfChunk * chunkSize
            val endIndex = startIndex + chunkSize
            return substringOrRest(endIndex, startIndex)
        }

        private fun String.substringOrRest(endIndex: Int, startIndex: Int)
                = if (endIndex >= length) substring(startIndex) else substring(startIndex, endIndex)

    }
}

