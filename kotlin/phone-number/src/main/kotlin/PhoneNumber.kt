class PhoneNumber(rawNumber: String) {
    private val countryCode = "1"

    val number: String
    val areaCode: String

    init {
        number = format(rawNumber)
        areaCode = number.take(3)
        require(number.length == 10)
    }

    override fun toString(): String = 
            "($areaCode) ${number.substring(3, 6)}-${number.substring(6, 10)}"

    private fun format(rawNumber: String): String {
        return rawNumber.filter { it.isDigit() }
                .let {
                    if (it.startsWith(countryCode)) it.drop(countryCode.length)
                    else it
                }
    }

}