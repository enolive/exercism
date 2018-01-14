export class ArgumentError implements Error {
    name: string = 'ArgumentError'
    message: string

    constructor(message: string) {
        this.message = message
    }
}

export class WordProblem {
    private operations = [
        {code: 'plus', func: (a: number, b: number) => a + b},
        {code: 'minus', func: (a: number, b: number) => a - b},
        {code: 'multiplied by', func: (a: number, b: number) => a * b},
        {code: 'divided by', func: (a: number, b: number) => a / b},
    ]

    private question: string

    constructor(question: string) {
        this.question = question
    }

    answer() {
        return this.processOperations(this.determineFirstNumber())
    }

    private secondTerm() {
        const allowedOperations = this.operations
            .map((o) => o.code)
            .join('|')
        return `((${allowedOperations}) (-?\\d+))`
    }

    private processOperations(initialValue: number) {
        const operationPattern = new RegExp(this.secondTerm(), 'g')
        let result = initialValue
        let matchOperation: RegExpExecArray | null
        do {
            matchOperation = operationPattern.exec(this.question)
            result = this.processOperation(matchOperation, result)
        } while (matchOperation)
        return result
    }

    private processOperation(matchOperation: RegExpExecArray | null, result: number) {
        if (matchOperation) {
            const operation = this.getOperation(matchOperation[2])
            const secondNumber = WordProblem.toDecimal(matchOperation[3])
            result = operation(result, secondNumber)
        }
        return result
    }

    private determineFirstNumber() {
        const wholePattern = new RegExp(`What is (-?\\d+)( ${this.secondTerm()})+\\?`)
        const matchWhole = wholePattern.exec(this.question)
        if (!matchWhole) {
            throw new ArgumentError(`I don't understand the given question ${this.question}`)
        }
        return WordProblem.toDecimal(matchWhole[1])
    }

    private static toDecimal(value: string) {
        return parseInt(value, 10)
    }

    private getOperation(operationCode: string) {
        const [operation] = this.operations
            .filter((o) => o.code === operationCode)
            .map((o) => o.func)
        return operation
    }
}