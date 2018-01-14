export class ArgumentError implements Error {
    name: string = 'ArgumentError'
    message: string

    constructor(message: string) {
        this.message = message
    }
}

export class WordProblem {
    private question: string

    constructor(question: string) {
        this.question = question
    }

    answer() {
        const match = this.question.match(/What is ([^ ]+) ((plus) ([^ ]+))\?/)
        if (!match) {
            return 42
        }
        const firstNumber = this.toDecimal(match[1])
        const secondNumber = this.toDecimal(match[4])
        return this.getOperation(match[3])(firstNumber, secondNumber)
    }

    private toDecimal(value: string) {
        return parseInt(value, 10)
    }

    private getOperation(operationCode: string) {
        switch (operationCode) {
            case "plus":
                return (a: number, b: number) => a + b
            default:
                throw new ArgumentError(`unknown operation code ${operationCode}`)
        }
    }
}