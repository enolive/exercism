class Result {
    constructor(readonly remainingInput: number, readonly currentFactor: number = 2, readonly found: number[] = []) {
    }

    next() {
        if (this.remainingInput % this.currentFactor === 0) {
            return new Result(this.remainingInput / this.currentFactor, 2, this.found.concat(this.currentFactor))
        }
        return new Result(this.remainingInput, this.currentFactor + 1, this.found)
    }

}

export default function calculatePrimeFactors(limit: number) {
    let result = new Result(limit)

    while (result.remainingInput !== 1) {
        result = result.next()
    }
    return result.found
}