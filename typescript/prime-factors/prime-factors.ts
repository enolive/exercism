export default function calculatePrimeFactors(limit: number) {
    return factorize(limit)
}

function factorize(remaining: number, found: number[] = []): number[] {
    if (remaining === 1) {
        return found
    }
    const tryFactor = getNextFactor(found, remaining)
    return factorize(remaining / tryFactor, found.concat(tryFactor))
}

function getNextFactor(found: number[], remaining: number) {
    let tryFactor = lastInOr(found, 2)
    while (remaining % tryFactor !== 0) {
        tryFactor++
    }
    return tryFactor
}

function lastInOr(found: number[], orValue: number) {
    const [tryFactor] = found.slice(-1)
    return tryFactor || orValue
}
