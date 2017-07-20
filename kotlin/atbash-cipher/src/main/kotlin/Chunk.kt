class Chunk(val value: String) {
    fun swapLetters(): Chunk {
        return Chunk(value
                .toCharArray()
                .map { swap(it) }
                .joinToString(""))
    }

    private fun swap(c: Char) = if (!c.isLetter()) c else 'z' - (c - 'a')
}