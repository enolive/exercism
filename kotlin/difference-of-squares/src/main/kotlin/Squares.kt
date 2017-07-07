class Squares(private val i: Int) {
    fun difference(): Int = squareOfSum() - sumOfSquares()

    fun squareOfSum(): Int = gauss().square()

    fun sumOfSquares(): Int = quadraticPyramidNumber()

    private fun gauss() = (i * (i + 1) / 2)

    private fun quadraticPyramidNumber() = i * (i + 1) * (2 * i + 1) / 6

    private fun Int.square() = this * this

}