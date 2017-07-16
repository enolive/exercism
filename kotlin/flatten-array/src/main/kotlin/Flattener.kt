object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        fun flattenIt(list: List<Any?>, acc: List<Any>): List<Any> {
            if (list.isEmpty()) {
                return acc
            }

            val first = list.first()
            if (first == null) {
                return acc
            }
            
            if (first is List<*>) {
                return flattenIt(list.drop(1), acc + flattenIt(first, emptyList()))
            }

            return flattenIt(list.drop(1), acc + first)
        }

        val result = emptyList<Any>()
        return flattenIt(list, result)
    }

}