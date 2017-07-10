object Luhn {
    fun isValid(numberCode: String): Boolean {
        if (numberCode.length >= 3) {
            return true
        }

        return false
    }

}