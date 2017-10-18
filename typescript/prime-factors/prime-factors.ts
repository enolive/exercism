import * as _ from "lodash"

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

export function isPrime(candidate: number): boolean {
    const upperLimit = Math.floor(Math.sqrt(candidate))
    const numbers = _.range(2, upperLimit + 1)
    return !numbers.some((n) => candidate % n === 0)
}

export function letThereBePrimes(limit: number) {
    const numbers = _.range(2, limit + 1)
    return numbers.filter((primeCandidate) => isPrime(primeCandidate))
}

export default function calculatePrimeFactors(limit: number) {
    const result = new Result(limit)
    const primes = letThereBePrimes(limit).filter((p) => limit % p === 0)

    function calculateTailRec(result: Result): Result {
        if (result.isAtEnd()) {
            return result
        }
        return calculateTailRec(primes.reduce((acc, prime) => acc.next(prime), result))
    }

    return calculateTailRec(result).primes
}