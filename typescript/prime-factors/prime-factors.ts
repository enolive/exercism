export default function calculatePrimeFactors(limit: number) {
    let result: number[] = []
    while (limit > 1) {
        if (limit % 2 === 0) {
            result = result.concat(2)
            limit /= 2
        }
        if (limit % 3 === 0) {
            result = result.concat(3)
            limit /= 3
        }
    }
    return result
}