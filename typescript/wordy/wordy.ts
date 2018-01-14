export class ArgumentError implements Error {
    name: string = 'ArgumentError'
    message: string

    constructor(message: string) {
        this.message = message
    }
}

export class WordProblem {
    private question: string
    private operations = [
        {word: 'plus', compute: (a: number, b: number) => a + b},
        {word: 'minus', compute: (a: number, b: number) => a - b},
        {word: 'multiplied by', compute: (a: number, b: number) => a * b},
        {word: 'divided by', compute: (a: number, b: number) => a / b},
    ]

    constructor(question: string) {
        this.question = question
    }

    answer() {
        const allowedOperations = this.operations.map((o) => o.word).join('|')
        const regExp = new RegExp(`What is (-?\\d+) ((${allowedOperations}) (-?\\d+))\\?`)
        const match = this.question.match(regExp)
        if (!match) {
            throw new ArgumentError(`I don't understand the given question ${this.question}`)
        }
        const firstNumber = this.toDecimal(match[1])
        const secondNumber = this.toDecimal(match[4])
        return this.getOperation(match[3])(firstNumber, secondNumber)
    }

    private toDecimal(value: string) {
        return parseInt(value, 10)
    }

    private getOperation(operationCode: string) {
        const [operation] = this.operations
            .filter((o) => o.word === operationCode)
            .map((o) => o.compute)
        return operation
    }
}