class PhoneNumber(rawNumber: String) {
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
                    if (it.startsWith("1")) it.drop(1)
                    else it
                }
    }

}