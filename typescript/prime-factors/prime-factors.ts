export default function calculatePrimeFactors(limit: number) {
    let result: number[] = []
    if (limit % 2 === 0) {
        result = result.concat(2)
        limit /= 2
    }
    if (limit % 3 === 0) {
        result = result.concat(3)
        limit /= 3
    }
    if (limit === 4) {
        result = [2].concat(result)
        limit /= 2
    }
    if (limit === 2) {
        result = [2].concat(result)
        limit /= 2
    }
    return result
}