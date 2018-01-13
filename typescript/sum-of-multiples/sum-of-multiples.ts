class Sum {
    private array: number[]

    constructor(array: number[]) {
        this.array = array

    }

    to(end: number): number {
        return 0
    }
}

export default function SumOfMultiples(array: number[]) {
    return new Sum(array)
}
