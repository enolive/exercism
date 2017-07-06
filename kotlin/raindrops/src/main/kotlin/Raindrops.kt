object Raindrops {
    fun convert(input: Int): String {
        if (input.isDivisibleBy(3)) {
            return "Pling"
        }
        
        return input.toString()
    }

    private fun Int.isDivisibleBy(denominator: Int) = this % denominator == 0

}