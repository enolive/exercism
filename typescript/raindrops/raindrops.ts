export default class Raindrops {
    private isDivisibleBy = (divisor: number) => (input: number) => input % divisor === 0
    private rules = [
        {appliesTo: this.isDivisibleBy(3), result: 'Pling'},
        {appliesTo: this.isDivisibleBy(5), result: 'Plang'},
        {appliesTo: this.isDivisibleBy(7), result: 'Plong'},
    ]

    convert(input: number) {
        return this.rules
            .filter((r) => r.appliesTo(input))
            .map((r) => r.result)
            .join('') || input.toString()
    }
}