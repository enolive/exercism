object CollatzCalculator {
    tailrec fun computeStepCount(i: Int, count: Int = 0) : Int {
        if (i == 1) {
            return count
        }
        
        return computeStepCount(next(i), count + 1)
    }

    private fun next(i: Int) = i / 2

}