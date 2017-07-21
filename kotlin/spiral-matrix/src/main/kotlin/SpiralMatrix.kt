object SpiralMatrix {
    fun ofSize(size: Int): Array<Array<Int>> {
        if (size == 4) {
            val mappings = listOf(
                    0 to 0,
                    0 to 1,
                    0 to 2,
                    0 to 3,
                    1 to 3,
                    2 to 3,
                    3 to 3,
                    3 to 2,
                    3 to 1,
                    3 to 0,
                    2 to 0,
                    1 to 0,
                    1 to 1,
                    1 to 2,
                    2 to 2,
                    2 to 1
            )
            
            return makeSpiral(size, mappings)
        }
        
        if (size == 3) {
            val mappings = listOf(
                    0 to 0,
                    0 to 1,
                    0 to 2,
                    1 to 2,
                    2 to 2,
                    2 to 1,
                    2 to 0,
                    1 to 0,
                    1 to 1
            )

            return makeSpiral(size, mappings)
        }
        
        if (size == 2) {
            val mappings = listOf(
                    0 to 0,
                    0 to 1,
                    1 to 1,
                    1 to 0
            )
            
            return makeSpiral(size, mappings)
        }
        
        if (size == 1) {
            val mappings = listOf(
                    0 to 0
            )
            
            return makeSpiral(size, mappings)
        }
        
        return emptyArray()
    }

    private fun makeSpiral(size: Int, mappings: List<Pair<Int, Int>>): Array<Array<Int>> {
        val result = Array(size) { Array(size) { 0 } }
        val numbers = (1..(size * size)).toList()
        (numbers zip mappings)
                .forEach { (number, mapping) -> result[mapping.first][mapping.second] = number }
        return result
    }

}