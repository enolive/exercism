class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String

    init {
        number = rawNumber.filter { it.isDigit() }
        areaCode = rawNumber
    }

}