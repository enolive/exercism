object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        fun flattenIt(remainingList: List<Any?>, acc: List<Any>): List<Any> {
            if (remainingList.isEmpty()) {
                return acc
            }

            val (howManyToDrop, firstValue) = remainingList
                    .indices
                    .filter { remainingList[it] != null }
                    .map { Pair(it + 1, remainingList[it] as Any) }
                    .firstOrNull() ?: return acc

            if (firstValue is List<*>) {
                return flattenIt(remainingList.drop(howManyToDrop), acc + flattenIt(firstValue, emptyList()))
            }

            return flattenIt(remainingList.drop(howManyToDrop), acc + firstValue)
        }

        return flattenIt(list, emptyList())
    }

}