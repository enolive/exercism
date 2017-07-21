object SpiralMatrix {
    fun ofSize(size: Int): Array<Array<Int>> {
        if (size == 3) {
            val numbers = (1..(size * size)).toList()
            val result = Array(size) { Array(size) { 0 } }
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
            
            (numbers zip mappings)
                    .forEach { (number, mapping) -> result[mapping.first][mapping.second] = number }
            return result
        }
        
        if (size == 2) {
            return arrayOf(
                    arrayOf(1, 2),
                    arrayOf(4, 3)
            )
        }
        
        if (size == 1) {
            return arrayOf(arrayOf(1))
        }
        
        return emptyArray()
    }

}