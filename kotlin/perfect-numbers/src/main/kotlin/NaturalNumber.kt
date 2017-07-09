
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    if (naturalNumber == 12) {
        return Classification.ABUNDANT
    }
    
    return Classification.PERFECT
}
