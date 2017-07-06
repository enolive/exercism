fun hello(name: String = ""): String {
    val person = if (!name.isNullOrBlank()) name else "World"
    return "Hello, $person!"
}
