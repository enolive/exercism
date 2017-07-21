object WordCount {
    fun phrase(phrase: String): Map<String, Int> {
        return phrase.split(' ').associate { it to 1 }
    }

}