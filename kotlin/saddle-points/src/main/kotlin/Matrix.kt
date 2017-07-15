class Matrix(val points: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            if (points.all { it.isEmpty() }) {
                return emptySet()
            }

            val allPoints = allPoints()
            return maxInRow(allPoints) intersect minInColumn(allPoints)
        }

    fun allPoints(): List<Pair<MatrixCoordinate, Int>> {
        return points.mapIndexed {
            rowIndex, row ->
            row.mapIndexed {
                columnIndex, value ->
                Pair(MatrixCoordinate(rowIndex, columnIndex), value)
            }
        }.flatMap { it }
    }

    fun minInColumn(allPoints: List<Pair<MatrixCoordinate, Int>>): Set<MatrixCoordinate> {
        val columns = allPoints.groupBy { it.first.col }
        return columns
                .map { column -> Pair(column, minimumValueIn(column)) }
                .map { (column, minimum) -> column.value.filter { (_, value) -> value == minimum } }
                .takeCoordinates()
    }

    fun maxInRow(allPoints: List<Pair<MatrixCoordinate, Int>>): Set<MatrixCoordinate> {
        val rows = allPoints.groupBy { it.first.row }
        return rows
                .map { row -> Pair(row, maximumValueIn(row)) }
                .map { (row, maximum) -> row.value.filter { (_, value) -> value == maximum } }
                .takeCoordinates()
    }

    private fun List<List<Pair<MatrixCoordinate, Int>>>.takeCoordinates(): Set<MatrixCoordinate> {
        return flatMap { it }
                .map { (coordinate, _) -> coordinate }
                .toSet()
    }

    private fun minimumValueIn(column: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>)
            = column.value.minBy { it.second }!!.second

    private fun maximumValueIn(row: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>) 
            = row.value.maxBy { it.second }!!.second



}