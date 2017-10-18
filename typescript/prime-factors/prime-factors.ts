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
                result = {
                    limit: result.limit / p,
                    primes: result.primes.concat(p)
                }
            })
    }
    return result.primes
}