object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        fun flattenIt(list: List<Any?>, acc: List<Any>): List<Any> {
            if (list.isEmpty()) {
                return acc
            }
            
            return acc
        }

        val result = emptyList<Any>()
        return flattenIt(list, result)
    }

}