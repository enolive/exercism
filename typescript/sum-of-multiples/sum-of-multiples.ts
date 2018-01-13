import * as _ from "lodash"

class Sum {
    private multiples: number[]

    constructor(multiples: number[]) {
        this.multiples = multiples
    }

    to(end: number): number {
        return _.range(1, end)
            .filter((n) => this.multiples.some((multiple) => this.isDivisibleBy(n, multiple)))
            .reduce((a, b) => a + b, 0)
    }

    private isDivisibleBy(n: number, denominator: number) {
        return n % denominator === 0
    }
}

export default function SumOfMultiples(array: number[]) {
    return new Sum(array)
}
