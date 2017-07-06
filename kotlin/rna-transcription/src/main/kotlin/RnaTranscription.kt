fun transcribeToRna(dna: String): String {
    when (dna) {
        "G" -> return "C"
        "T" -> return "A"
        else -> return "G"
    }

}
