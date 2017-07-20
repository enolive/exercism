class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String
    private val countryCode = "1"

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(cleanNumber.isValid())

        number = cleanNumber.dropCountryCode()
        areaCode = rawNumber.take(3)
    }

    private fun String.isValid(): Boolean {
        return when {
            length < 10 -> false
            length == 10 && startsWith(countryCode) -> false
            hasCountryCode() && !startsWith(countryCode) -> false
            else -> true
        }
    }

    private fun String.dropCountryCode(): String =
            when {
                hasCountryCode() -> drop(countryCode.length)
                else -> this
            }

    private fun String.hasCountryCode() = length == 11

}