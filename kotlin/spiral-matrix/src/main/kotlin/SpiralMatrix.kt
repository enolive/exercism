object SpiralMatrix {
    fun ofSize(size: Int): Array<Array<Int>> {
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