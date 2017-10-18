class Result {
    constructor(readonly limit: number, readonly primes: number[] = []) {
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

    while (!result.isAtEnd()) {
        primes.forEach((p) => {
            result = result.next(p)
        })
    }
    return result.primes
}