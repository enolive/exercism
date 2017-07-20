object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val sanitizedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
        return Chunks.of(sanitizedInput).withSize(5)
                .map { it.encode() }
                .joinToString(" ")
    }

    
}


