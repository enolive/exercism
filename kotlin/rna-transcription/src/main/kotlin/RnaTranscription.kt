fun transcribeToRna(dna: String): String {
    return getComplement(dna[0]).toString()
}

private fun getComplement(dnaSymbol: Char): Char {
    when (dnaSymbol) {
        'G' -> return 'C'
        'T' -> return 'A'
        'A' -> return 'U'
        else -> return 'G'
    }
}
