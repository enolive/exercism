object Isogram {
    fun isIsogram(input: String): Boolean {
        val characterCount = input
                .toCharArray()
                .filter { it !in listOf(' ', '-') }
                .map { it.toUpperCase() }
                .groupBy { it }
        return characterCount.all { it.value.count() == 1 }
    }

}