export default function calculatePrimeFactors(limit: number) {
    let result: number[] = []
    const primes = [2, 3]
    while (limit > 1) {
        primes.forEach((p) => {
            if (limit % p === 0) {
                result = result.concat(p)
                limit /= p
            }
        })
    }
    return result
}