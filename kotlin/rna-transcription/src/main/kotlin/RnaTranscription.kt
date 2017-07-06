fun transcribeToRna(dna: String): String {
    return dna
            .map(::transcribeSingle)
            .joinToString(separator = "")
}

private fun transcribeSingle(dnaSymbol: Char): Char {
    when (dnaSymbol) {
        'G' -> return 'C'
        'T' -> return 'A'
        'A' -> return 'U'
        else -> return 'G'
    }
}
