class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(isValid(cleanNumber))

        number = if (cleanNumber.length == 11) {
            cleanNumber.drop(1)
        } else {
            cleanNumber
        }
        areaCode = rawNumber
    }

    private fun isValid(cleanNumber: String): Boolean {
        return when {
            cleanNumber.length == 10 && cleanNumber.startsWith("1") -> false
            cleanNumber.length == 11 && !cleanNumber.startsWith("1") -> false
            else -> true
        }

    }

}