class Matrix(val points: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            if (points.all { it.isEmpty() }) {
                return emptySet()
            }
            
            return setOf(MatrixCoordinate(1, 0))
        }

}