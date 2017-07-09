
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    val sum = naturalNumber.sumOfQuotients()
    when {
        sum > naturalNumber -> return Classification.ABUNDANT
        sum < naturalNumber -> return Classification.DEFICIENT
        else -> return Classification.PERFECT
    }
}

private fun Int.sumOfQuotients(): Int {
    val aliquot = (1..this - 1)
            .filter { isDivisibleBy(it) }
            .sum()
    return aliquot
}

private fun Int.isDivisibleBy(it: Int) = this % it == 0
