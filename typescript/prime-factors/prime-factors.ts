function next(result: { limit: number; primes: number[] }, p) {
    return {
        limit: result.limit / p,
        primes: result.primes.concat(p)
    }
}

export default function calculatePrimeFactors(limit: number) {
    let result = {
        limit: limit,
        primes: [],
    }
    const primes = [2, 3]

    while (result.limit > 1) {
        primes
            .filter((p) => result.limit % p === 0)
            .forEach((p) => {
                result = next(result, p)
            })
    }
    return result.primes
}