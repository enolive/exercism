class Result {
    constructor(private readonly limit: number, readonly primes: number[] = []) {
    }

    next(prime: number): Result {
        return new Result(this.limit / prime, this.primes.concat(prime))
    }
    
    isAtEnd() {
        return this.limit === 1
    }
}

function letThereBePrimes(limit: number) {
    return [2, 3, 5].filter((p) => limit % p === 0)
}

export default function calculatePrimeFactors(limit: number) {
    const result = new Result(limit)
    const primes = letThereBePrimes(limit)

    function calculateTailRec(result: Result): Result {
        if (result.isAtEnd()) {
            return result
        }
        return calculateTailRec(primes.reduce((acc, prime) => acc.next(prime), result))
    }

    return calculateTailRec(result).primes
}