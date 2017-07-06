object Hamming {
    fun compute(leftStrand: String, rightStrand: String): Int {
        requireEqualLength(leftStrand, rightStrand)
        return (leftStrand zip rightStrand)
                .count { it.first != it.second }
    }

    private fun requireEqualLength(leftStrand: String, rightStrand: String) {
        require (leftStrand.length == rightStrand.length) {
            "leftStrand and rightStrand must be of equal length."
        }
    }

}