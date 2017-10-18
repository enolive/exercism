export default function calculatePrimeFactors(limit: number) {
    let result: number[] = []
    if (limit === 6) {
        result = [3].concat(result)
        limit = 6 / 3
    }
    if (limit === 4) {
        result = [2].concat(result)
        limit = 4 / 2
    }
    if (limit === 3) {
        result = [3].concat(result)
        limit = 3 / 3
    }
    if (limit === 2) {
        result = [2].concat(result)
        limit = 2 / 2
    }
    return result
}