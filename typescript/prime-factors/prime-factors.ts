export default function calculatePrimeFactors(limit: number) {
    return factor(limit)
}

function factor(remaining: number, found: number[] = []): number[] {
    if (remaining === 1) {
        return found
    }
    let tryFactor: number = found.length > 0 ? found[found.length - 1] : 2
    while (remaining % tryFactor !== 0) {
        tryFactor++
    }
    found.push(tryFactor)
    return factor(remaining / tryFactor, found)
}