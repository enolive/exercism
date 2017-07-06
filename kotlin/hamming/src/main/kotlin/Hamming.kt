object Hamming {
    fun compute(leftStrand: String, rightStrand: String): Int {
        throwOnLengthMismatch(leftStrand, rightStrand)
        return leftStrand
                .zip(rightStrand)
                .filter { (left, right) -> left != right }
                .count()
    }

    private fun throwOnLengthMismatch(leftStrand: String, rightStrand: String) {
        require (leftStrand.length == rightStrand.length) {
            "leftStrand and rightStrand must be of equal length."
        }
    }

}