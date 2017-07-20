class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String
    private val countryCode = "1"

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(when {
            cleanNumber.length < 10 -> false
            cleanNumber.length == 10 && cleanNumber.startsWith(countryCode) -> false
            cleanNumber.hasCountryCode() && !cleanNumber.startsWith(countryCode) -> false
            else -> true
        })

        number = dropCountryCode(cleanNumber)
        areaCode = rawNumber.take(3)
    }

    private fun dropCountryCode(cleanNumber: String): String {
        return when {
            cleanNumber.hasCountryCode() -> cleanNumber.drop(countryCode.length)
            else -> cleanNumber
        }
    }

    private fun String.hasCountryCode() = length == 11

}