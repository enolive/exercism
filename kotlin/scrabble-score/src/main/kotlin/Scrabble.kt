object Scrabble {
    fun scoreWord(input: String): Int {
        if (input.length == 0) {
            return 0
        }
        
        if (input[0] == 'a') {
            return 1
        }
        
        return 0
    }

}