object Hamming {
    fun compute(first: String, second: String): Int {
        if (first != second) {
            return first.zip(second).filter { (f, s) -> f != s }.count()
        }

        return 0
    }

}