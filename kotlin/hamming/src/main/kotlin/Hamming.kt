object Hamming {
    fun compute(first: String, second: String): Int {
        return first
                .zip(second)
                .filter { (f, s) -> f != s }
                .count()
    }

}