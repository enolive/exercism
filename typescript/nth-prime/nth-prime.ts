export default class Prime {
    nth(which: number): number {
        Prime.throwIfInvalid(which)
        let result = 2
        while (which-- > 1) {
            result = Prime.next(result)
        }
        return result
    }

    private static throwIfInvalid(which: number) {
        if (which <= 0) {
            throw 'Prime is not possible'
        }
    }

    private static isOnlyDivisibleByItself(test: number) {
        for (let i = 2; i <= Math.sqrt(test); i++) {
            if (test !== i && test % i === 0) {
                return false
            }
        }
        return true
    }

    private static next(previous: number) {
        let newTest = previous + 1
        while (!Prime.isOnlyDivisibleByItself(newTest)) {
            newTest++
        }
        return newTest
    }
}
