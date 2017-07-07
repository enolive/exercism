class Squares(private val i: Int) {
    fun difference(): Int = squareOfSum() - sumOfSquares()

    fun squareOfSum(): Int = gauss().square()

    fun sumOfSquares(): Int = squarePyramidalNumber()

    private fun gauss() = (i * (i + 1) / 2)

    private fun squarePyramidalNumber() = i * (i + 1) * (2 * i + 1) / 6

    private fun Int.square() = this * this

}