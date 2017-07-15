class Matrix(val points: List<List<Int>>) {
    val saddlePoints: Set<MatrixCoordinate>
        get() {
            if (points.all { it.isEmpty() }) {
                return emptySet()
            }

            val allPoints = allPoints()
            return maxInRow(allPoints) intersect minInColumn(allPoints)
        }

    fun minInColumn(allPoints: List<Pair<MatrixCoordinate, Int>>): Set<MatrixCoordinate> {
        val columns = allPoints.groupBy { it.first.col }
        
        return columns
                .map { column -> Pair(column, minimumValueIn(column)) }
                .map { (column, minimum) -> column.value.filter { (_, value) -> value == minimum } }
                .flatMap { it }
                .map { (coordinate, _) -> coordinate }
                .toSet()
    }

    fun maxInRow(allPoints: List<Pair<MatrixCoordinate, Int>>): Set<MatrixCoordinate> {
        val rows = allPoints.groupBy { it.first.row }
        return rows
                
                .map { row -> row.value.filter { r -> r.second == maximumInRow(row) } }
                .flatMap { it }
                .map { it.first }
                .toSet()
    }

    private fun minimumValueIn(column: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>)
            = column.value.minBy { it.second }!!.second

    private fun maximumInRow(row: Map.Entry<Int, List<Pair<MatrixCoordinate, Int>>>) 
            = row.value.maxBy { it.second }!!.second

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