class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String
    private val countryCode = "1"
    private val stringRepresentation: String

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(isValid(cleanNumber))

        number = dropCountryCode(cleanNumber)
        areaCode = number.take(3)

        stringRepresentation = makeString()
    }

    private fun makeString(): String {
        val strippedNumber = number.drop(areaCode.length)
        return "($areaCode) ${strippedNumber.take(3)}-${strippedNumber.drop(3)}"
    }

    override fun toString(): String {
        return stringRepresentation
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