
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    val aliquot = (1..naturalNumber - 1)
            .filter {  naturalNumber % it == 0 }
            .sum()
    
    if (aliquot > naturalNumber) {
        return Classification.ABUNDANT
    }
    
    if (aliquot < naturalNumber) {
        return Classification.DEFICIENT
    }
    
    return Classification.PERFECT
}
