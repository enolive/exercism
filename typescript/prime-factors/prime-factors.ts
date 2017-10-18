class Result {
    constructor(private readonly limit: number, readonly primes: number[] = []) {
    }

    next(prime: number): Result {
        return new Result(this.limit / prime, this.primes.concat(prime))
    }

    isDivisibleBy(prime: number) {
        return this.limit % prime === 0
    }

    isAtEnd() {
        return this.limit === 1
    }
}

export default function calculatePrimeFactors(limit: number) {
    let result = new Result(limit)
    const primes = [2, 3].filter((p) => result.isDivisibleBy(p))

    function calculateTailRec(result: Result): Result {
        if (result.isAtEnd()) {
            return result
        }
        return calculateTailRec(primes.reduce((acc, prime) => acc.next(prime), result))
    }
    return calculateTailRec(result).primes

    while (!result.isAtEnd()) {
        const newResult = primes.reduce((acc, prime) => acc.next(prime), result)
        result = newResult
    }

    return result.primes
}