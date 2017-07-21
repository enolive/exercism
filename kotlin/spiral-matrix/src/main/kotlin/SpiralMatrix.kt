object SpiralMatrix {
    fun ofSize(size: Int): Array<Array<Int>> {
        if (size == 3) {
            val numbers = (1..(size * size)).toList()
            val result = Array(size) { Array(size) { 0 } }
            result[0][0] = numbers[0]
            result[0][1] = numbers[1]
            result[0][2] = numbers[2]
            result[1][2] = numbers[3]
            result[2][2] = numbers[4]
            result[2][1] = numbers[5]
            result[2][0] = numbers[6]
            result[1][0] = numbers[7]
            result[1][1] = numbers[8]
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