object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        return input.toCharArray()
                .map { encode(it) }
                .joinToString("")
    }

    private fun encode(c: Char) = 'z' - (c - 'a')

}