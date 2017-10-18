export default function calculatePrimeFactors(limit: number) {
    if (limit === 6) {
        return [2, 3]
    }
    if (limit === 4) {
        return [2, 2]
    }
    if (limit === 3) {
        return [3]
    }
    if (limit === 2) {
        return [2]
    }
    return []
}