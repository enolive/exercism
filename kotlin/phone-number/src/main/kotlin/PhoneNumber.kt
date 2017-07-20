class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String
    private val countryCode = "1"
    private val stringRepresenation: String

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(isValid(cleanNumber))

        number = dropCountryCode(cleanNumber)
        areaCode = number.take(3)

        stringRepresenation = makeString()
    }

    private fun makeString(): String {
        val strippedNumber = number.drop(areaCode.length)
        val theString = "($areaCode) ${strippedNumber.take(3)}-${strippedNumber.drop(3)}"
        return theString
    }

    override fun toString(): String {
        return stringRepresenation
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