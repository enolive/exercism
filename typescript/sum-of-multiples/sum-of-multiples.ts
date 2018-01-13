import * as _ from "lodash"

export default (multiples: number[]) => {
    return new SumOfMultiples(multiples)
}

class SumOfMultiples {
    private multiples: number[]

    constructor(multiples: number[]) {
        this.multiples = multiples
    }

    to(end: number): number {
        return _.range(1, end)
            .filter((n) => SumOfMultiples.is(n).multipleOf(this.multiples))
            .reduce((sum, n) => sum + n, 0)
    }

    private static is(n: number) {
        return {
            multipleOf: (multiples: number[]) => multiples.some((m) => n % m === 0)
        }
    }
}
