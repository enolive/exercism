object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        fun flattenIt(list: List<Any?>, acc: List<Any>): List<Any> {
            if (list.isEmpty()) {
                return acc
            }

            var howManyToDrop = 0
            var first: Any?
            do {
                first = list.elementAt(howManyToDrop)
                howManyToDrop++
            } while (first == null && howManyToDrop < list.size)

            if (first == null) {
                return acc
            }
            
            if (first is List<*>) {
                return flattenIt(list.drop(howManyToDrop), acc + flattenIt(first, emptyList()))
            }

            return flattenIt(list.drop(howManyToDrop), acc + first)
        }

        val result = emptyList<Any>()
        return flattenIt(list, result)
    }

}