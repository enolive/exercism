
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    val aliquot = (1..naturalNumber - 1)
            .filter { naturalNumber.isDivisibleBy(it) }
            .sum()

    when {
        aliquot > naturalNumber -> return Classification.ABUNDANT
        aliquot < naturalNumber -> return Classification.DEFICIENT
        else -> return Classification.PERFECT
    }

}

private fun Int.isDivisibleBy(it: Int) = this % it == 0
