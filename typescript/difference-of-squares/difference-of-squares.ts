import * as _ from "lodash"

export default class DifferenceOfSquares {
    readonly squareOfSums: number
    private sum = (a: number, b: number): number => a + b

    constructor(end: number) {
        this.squareOfSums = _.range(1, end + 1).reduce(this.sum) ** 2
    }
}