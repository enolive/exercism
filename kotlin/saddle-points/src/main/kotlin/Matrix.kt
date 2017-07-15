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
        return findCoordinates(columns, { column -> minimumValueIn(column) })
    }

    fun maxInRow(allPoints: List<Pair<MatrixCoordinate, Int>>): Set<MatrixCoordinate> {
        val rows = allPoints.groupBy { it.first.row }
        return findCoordinates(rows, { row -> maximumValueIn(row) })
    }

    private fun findCoordinates(group: Map<Int, List<Pair<MatrixCoordinate, Int>>>, aggregate: (Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>) -> Int): Set<MatrixCoordinate> {
        return group
                .map { items -> Pair(items, aggregate(items)) }
                .map { (items, aggregatedValue) -> items.value.filter { (_, value) -> value == aggregatedValue } }
                .flatMap { it }
                .map { (coordinate, _) -> coordinate }
                .toSet()
    }

    private fun minimumValueIn(column: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>)
            = column.value.minBy { it.second }!!.second

    private fun maximumValueIn(row: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>)
            = row.value.maxBy { it.second }!!.second

}