class Squares(private val i: Int) {
    fun squareOfSum(): Int = (1..i).sum().square()

    fun sumOfSquares(): Int = (1..i).sumBy { it.square() }

    fun difference(): Int = squareOfSum() - sumOfSquares()

    private fun Int.square() = this * this

}