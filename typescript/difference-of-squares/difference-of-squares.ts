export default class DifferenceOfSquares {
    readonly squareOfSums: number
    readonly sumOfSquares: number
    readonly difference: number

    constructor(end: number) {
        this.squareOfSums = DifferenceOfSquares.arithmeticSum(end) ** 2
        this.sumOfSquares = DifferenceOfSquares.squarePyramidalNumber(end)
        this.difference = this.squareOfSums - this.sumOfSquares
    }

    private static arithmeticSum(end: number) {
        // see https://en.wikipedia.org/wiki/Arithmetic_progression#Sum
        return (1 + end) * end / 2
    }

    private static squarePyramidalNumber(end: number) {
        // see https://en.wikipedia.org/wiki/Square_pyramidal_number
        return end * (end + 1) * (2 * end + 1) / 6
    }
}