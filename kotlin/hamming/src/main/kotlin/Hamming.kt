import java.lang.IllegalArgumentException

object Hamming {
    fun compute(leftStrand: String, rightStrand: String): Int {
        throwOnLengthMismatch(leftStrand, rightStrand)
        return leftStrand
                .zip(rightStrand)
                .filter { (left, right) -> left != right }
                .count()
    }

    private fun throwOnLengthMismatch(leftStrand: String, rightStrand: String) {
        if (leftStrand.length != rightStrand.length) {
            throw IllegalArgumentException("leftStrand and rightStrand must be of equal length.")
        }
    }

}