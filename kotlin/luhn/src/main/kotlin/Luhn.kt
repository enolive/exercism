object Luhn {
    fun isValid(numberCode: String): Boolean {
        if (numberCode.length < 2) {
            return false
        }
        
        return numberCode.reversed()
                .map { it.toInt() - '0'.toInt() }
                .mapIndexed { index, digit -> if ((index + 1) % 2 == 0) digit * 2 else digit }
                .map { if (it > 9) it - 9 else it }
                .sum() % 10 == 0
    }
}