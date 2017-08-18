export default class HelloWorld {

    static hello(name?: string) {
        name = name || "World"
        return `Hello, ${name}!`
    }
}