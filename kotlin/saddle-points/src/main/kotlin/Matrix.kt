class Matrix(val points: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            if (points.all { it.isEmpty() }) {
                return emptySet()
            }

            val allPoints = allPoints()
            return maxInRow(allPoints) intersect minInColumn(allPoints)
        }

    fun minInColumn(allPoints: List<Pair<MatrixCoordinate, Int>>) 
            = allPoints.groupBy { it.first.col }
            .map { column -> column.value.minBy { it.second }!!.first }
            .toSet()

    fun maxInRow(allPoints: List<Pair<MatrixCoordinate, Int>>) 
            = allPoints.groupBy { it.first.row }
            .map { row -> row.value.maxBy { it.second }!!.first }
            .toSet()

    fun allPoints(): List<Pair<MatrixCoordinate, Int>> {
        return points.mapIndexed {
            rowIndex, row ->
            row.mapIndexed {
                columnIndex, value ->
                Pair(MatrixCoordinate(rowIndex, columnIndex), value)
            }
        }.flatMap { it }
    }



}