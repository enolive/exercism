object Isogram {
    fun isIsogram(input: String): Boolean {
        val characterCount = input.toCharArray().groupBy { it }
        return characterCount.all { it.value.count() == 1 }
    }

}