class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String
    private val countryCode = "1"

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(isValid(cleanNumber))

        number = dropCountryCode(cleanNumber)
        areaCode = rawNumber.take(3)
    }

    private fun isValid(number: String): Boolean {
        return when {
            number.length < 10 -> false
            hasNoCountryCode(number) && number.startsWith(this.countryCode) -> false
            hasCountryCode(number) && !number.startsWith(this.countryCode) -> false
            else -> true
        }
    }

    private fun dropCountryCode(number: String): String =
            when {
                hasCountryCode(number) -> number.drop(this.countryCode.length)
                else -> number
            }

    private fun hasNoCountryCode(number: String) = number.length == 10

    private fun hasCountryCode(number: String) = number.length == 11

}