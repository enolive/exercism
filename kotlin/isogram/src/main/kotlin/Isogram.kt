object Isogram {
    fun isIsogram(input: String): Boolean {
        val characterMap = input
                .toCharArray()
                .filter { it.isLetter() }
                .map { it.toUpperCase() }
                .groupBy { it }
        return characterMap.all { it.value.size == 1 }
    }

}