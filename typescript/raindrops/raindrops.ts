export default class Raindrops {

    private rules = [
        {appliesTo: this.isDivisibleBy(3), result: 'Pling'},
        {appliesTo: this.isDivisibleBy(5), result: 'Plang'},
        {appliesTo: this.isDivisibleBy(7), result: 'Plong'},
    ]

    convert(input: number) {
        const match = this.rules
            .filter((r) => r.appliesTo(input))
            .map((r) => r.result)
            .join('')
        return match || '1'
    }

    private isDivisibleBy(divisor: number) {
        return (input: number) => {
            return input % divisor === 0
        }
    }
}