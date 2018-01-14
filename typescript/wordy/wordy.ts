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
        const firstOperand = this.getFirstOperand()
        return this.processOperations(firstOperand)
    }

    private static operand() {
        return `-?\\d+`
    }

    private static toDecimal(value: string) {
        return parseInt(value, 10)
    }

    private operatorOperand() {
        const allowedOperations = this.operations
            .map((o) => o.code)
            .join('|')
        return `((${allowedOperations}) (${WordProblem.operand()}))`
    }

    private processOperations(firstOperand: number) {
        const pattern = new RegExp(this.operatorOperand(), 'g')
        let result = firstOperand
        let match: RegExpExecArray | null
        do {
            match = pattern.exec(this.question)
            result = this.processOperation(match, result)
        } while (match)
        return result
    }

    private processOperation(matchOperation: RegExpExecArray | null, result: number) {
        if (matchOperation) {
            const operation = this.getOperation(matchOperation[2])
            const operand = WordProblem.toDecimal(matchOperation[3])
            result = operation(result, operand)
        }
        return result
    }

    private getFirstOperand() {
        const pattern = new RegExp(`What is (${WordProblem.operand()})( ${this.operatorOperand()})+\\?`)
        const match = pattern.exec(this.question)
        if (!match) {
            throw new ArgumentError(`I don't understand the given question ${this.question}`)
        }
        return WordProblem.toDecimal(match[1])
    }

    private getOperation(operationCode: string) {
        const [operation] = this.operations
            .filter((o) => o.code === operationCode)
            .map((o) => o.func)
        return operation
    }
}