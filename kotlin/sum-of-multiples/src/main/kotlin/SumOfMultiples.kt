object SumOfMultiples {
    fun sum(quotients: Set<Int>, number: Int): Int {
        return (1..number)
                .filter { n -> quotients.any { q -> n % q == 0 } }
                .sum()
    }

}