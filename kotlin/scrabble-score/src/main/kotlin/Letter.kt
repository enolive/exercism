class Letter(value: Char) {
    private val normalizedValue = value.toLowerCase()

    fun score(): Int {
        return when (normalizedValue) {
            in "aeilnorstu" -> 1
            in "dg" -> 2
            in "bcmp" -> 3
            in "fhy" -> 4
            in "k" -> 5
            in "jx" -> 8
            in "qz" -> 10
            else -> {
                throw IllegalArgumentException("invalid letter '$normalizedValue'")
            }
        }
    }

}