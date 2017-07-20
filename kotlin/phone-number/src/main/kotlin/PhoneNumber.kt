class PhoneNumber(rawNumber: String) {
    val number: String
    val areaCode: String

    init {
        val cleanNumber = rawNumber.filter { it.isDigit() }
        require(when {
            cleanNumber.length < 10 -> false
            cleanNumber.length == 10 && cleanNumber.startsWith("1") -> false
            cleanNumber.length == 11 && !cleanNumber.startsWith("1") -> false
            else -> true
        })

        number = if (cleanNumber.length == 11) {
            cleanNumber.drop(1)
        } else {
            cleanNumber
        }
        areaCode = rawNumber
    }

}