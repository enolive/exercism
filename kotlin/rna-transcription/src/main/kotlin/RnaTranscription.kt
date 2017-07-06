fun transcribeToRna(dna: String): String {
    return dna
            .map { symbol -> convertToRna(symbol) }
            .joinToString(separator = "")
}

private fun convertToRna(dnaSymbol: Char): Char {
    when (dnaSymbol) {
        'G' -> return 'C'
        'T' -> return 'A'
        'A' -> return 'U'
        else -> return 'G'
    }
}
