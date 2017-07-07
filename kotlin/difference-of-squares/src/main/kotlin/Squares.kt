class Squares(private val i: Int) {
    fun squareOfSum(): Int {
        return (1..i).sum().square()
    }

    fun difference(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun sumOfSquares(): Int {
        return (1..i).map { it.square() }.sum()
    }

    private fun Int.square() = this * this

}