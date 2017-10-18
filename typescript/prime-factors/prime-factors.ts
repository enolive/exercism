class Result {
    constructor(readonly remainingInput: number, readonly currentFactor: number, readonly found: number[]) {
    }

    next() {
        if (this.remainingInput % this.currentFactor === 0) {
            return new Result(this.remainingInput / this.currentFactor, 2, this.found.concat(this.currentFactor))
        }
        return new Result(this.remainingInput, this.currentFactor + 1, this.found)
    }

}

function next(result: Result) {
    return result.next()
}

export default function calculatePrimeFactors(limit: number) {
    let result = new Result(limit, 2, [])

    while (result.remainingInput !== 1) {
        result = next(result)
    }
    return result.found
}