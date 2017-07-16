object Flattener {
    fun flatten(list: List<Any?>): List<Any> {
        return list
                .filterNotNull()
                .flatMap { 
            when (it) {
                is List<*> -> flatten(it)
                else -> listOf(it)
             }
        }
    }
}