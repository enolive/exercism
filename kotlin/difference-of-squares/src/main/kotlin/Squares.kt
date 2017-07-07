class Squares(private val i: Int) {
    fun squareOfSum(): Int {
        return (1..i).sum().square()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }

    fun sumOfSquares(): Int {
        return (1..i).map { it.square() }.sum()
    }

    private fun Int.square() = this * this

}