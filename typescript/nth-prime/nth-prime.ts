export default class Prime {
    nth(which: number): number {
        Prime.throwIfInvalid(which)
        const alreadyFoundPrimes = [2, 3, 5, 7]
        while (alreadyFoundPrimes.length < which) {
            const nextPrime = Prime.next(alreadyFoundPrimes)
            alreadyFoundPrimes.push(nextPrime)
        }
        return alreadyFoundPrimes[which - 1]
    }

    private static throwIfInvalid(which: number) {
        if (which <= 0) {
            throw 'Prime is not possible'
        }
    }

    private static next(alreadyFoundPrimes: number[]) {
        let result = this.last(alreadyFoundPrimes) + 1
        while (alreadyFoundPrimes.some((p) => result % p === 0)) {
            result++
        }
        return result
    }

    private static last(list: number[]) {
        return list[list.length - 1]
    }
}
