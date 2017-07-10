
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    val sum = naturalNumber.sumOfQuotients()
    return when {
        sum > naturalNumber -> Classification.ABUNDANT
        sum < naturalNumber -> Classification.DEFICIENT
        else -> Classification.PERFECT
    }
}

private fun Int.sumOfQuotients(): Int {
    return (1..this / 2)
            .filter { isDivisibleBy(it) }
            .sum()
}

private fun Int.isDivisibleBy(it: Int) = this % it == 0
