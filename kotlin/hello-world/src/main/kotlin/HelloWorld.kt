fun hello(name: String = ""): String {
   if (name != "") {
      return "Hello, $name!"
   }
   
   return "Hello, World!"
}
