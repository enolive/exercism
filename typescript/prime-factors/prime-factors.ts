class Result {
    constructor(readonly currentFactor: number, readonly remainingInput: number, readonly found: number[]) {
    }


}

function next(result: Result) {
    if (result.remainingInput % result.currentFactor === 0) {
        result = new Result(2, result.remainingInput / result.currentFactor, result.found.concat(result.currentFactor))
    }
    else {
        result = new Result(result.currentFactor + 1, result.remainingInput, result.found)
    }
    return result
}

export default function calculatePrimeFactors(limit: number) {
    let result = new Result(2, limit, [])

    while (result.remainingInput !== 1) {
        result = next(result)
    }
    return result.found
}