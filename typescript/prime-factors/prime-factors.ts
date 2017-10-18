class Result {
    constructor(readonly limit: number, readonly primes: number[] = []) {
    }

    next(prime: number): Result {
        return new Result(this.limit / prime, this.primes.concat(prime))
    }
}

export default function calculatePrimeFactors(limit: number) {
    let result = new Result(limit)
    const primes = [2, 3]

    while (result.limit > 1) {
        primes
            .filter((p) => result.limit % p === 0)
            .forEach((p) => {
                result = result.next(p)
            })
    }
    return result.primes
}