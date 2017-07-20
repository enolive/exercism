object Atbash {
    fun decode(input: String): String {
        val cleanInput = input.filter { it.isLetterOrDigit() }
        return Chunk(cleanInput).transcode()
    }

    fun encode(input: String): String {
        val cleanInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
        return Chunks.of(cleanInput).withSize(5)
                .map { it.transcode() }
                .joinToString(" ")
    }

}


