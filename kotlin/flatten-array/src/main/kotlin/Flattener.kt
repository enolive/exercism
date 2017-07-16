object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        fun flattenIt(list: List<Any?>, acc: List<Any>): List<Any> {
            if (list.isEmpty()) {
                return acc
            }

            val nextElement = list
                    .indices
                    .filter { list[it] != null }
                    .map { Pair(it + 1, list[it] as Any) }
                    .firstOrNull()
            if (nextElement == null) {
                return acc
            }
            
            val (howManyToDrop, first) = nextElement
            
            if (first is List<*>) {
                return flattenIt(list.drop(howManyToDrop), acc + flattenIt(first, emptyList()))
            }

            return flattenIt(list.drop(howManyToDrop), acc + first)
        }

        val result = emptyList<Any>()
        return flattenIt(list, result)
    }

}