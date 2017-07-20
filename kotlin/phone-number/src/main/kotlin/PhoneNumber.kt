class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        number = if (cleanNumber.length == 11) {
            cleanNumber.drop(1)
        } else {
            cleanNumber
        }
        areaCode = rawNumber
    }

}