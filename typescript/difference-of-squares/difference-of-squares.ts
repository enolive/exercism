import * as _ from "lodash"

export default class DifferenceOfSquares {
    readonly squareOfSums: number
    readonly sumOfSquares: number
    readonly difference: number
    private sum = (a: number, b: number): number => a + b
    private numbersUpTo = (end: number) => _.range(1, end + 1)

    constructor(end: number) {
        this.squareOfSums = this.numbersUpTo(end).reduce(this.sum) ** 2
        this.sumOfSquares = this.numbersUpTo(end).map((value) => value ** 2).reduce(this.sum)
        this.difference = this.squareOfSums - this.sumOfSquares
    }
}