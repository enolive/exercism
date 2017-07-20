object Atbash {
    fun decode(input: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun encode(input: String): String {
        val first = input[0]
        val second = input[1]
        return "" + ('z' - (first - 'a')) + ('z' - (second- 'a'))
    }

}