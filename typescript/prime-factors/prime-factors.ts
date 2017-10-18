export default function calculatePrimeFactors(limit: number) {
    return factorize(limit)
}

function factorize(remaining: number, found: number[] = []): number[] {
    if (remaining === 1) {
        return found
    }
    const nextFactor = getNextFactor(found, remaining)
    return factorize(remaining / nextFactor, found.concat(nextFactor))
}

function getNextFactor(found: number[], remaining: number) {
    let tryFactor = lastInOr(found, 2)
    while (remaining % tryFactor !== 0) {
        tryFactor++
    }
    return tryFactor
}

function lastInOr(found: number[], orValue: number) {
    const [last] = found.slice(-1)
    return last || orValue
}
