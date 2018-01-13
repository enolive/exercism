import * as _ from "lodash"

export default function SumOfMultiples(array: number[]) {
    return new Sum(array)
}

class Sum {
    private multiples: number[]

    constructor(multiples: number[]) {
        this.multiples = multiples
    }

    to(end: number): number {
        return _.range(1, end)
            .filter((n) => Sum.is(n).multipleOf(this.multiples))
            .reduce((a, b) => a + b, 0)
    }

    private static is(n: number) {
        return new Is(n)
    }
}

class Is {
    private n: number

    constructor(n: number) {
        this.n = n
    }

    multipleOf(multiples: number[]): boolean {
        return multiples.some(this.areMultiples())
    }

    private areMultiples() {
        return (multiple: number) => this.n % multiple === 0
    }

}
