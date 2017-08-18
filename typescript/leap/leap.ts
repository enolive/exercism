export default function isLeapYear(year: number) {
    const ruleChain = [
        {divisor: 400, result: true},
        {divisor: 100, result: false},
        {divisor: 4, result: true},
    ]

    const matches = ruleChain
        .filter((rule) => isDivisibleBy(year, rule.divisor))
        .map((rule) => rule.result)
    return headOf(matches)
}

function headOf(matches: boolean[]) {
    return matches[0]
}

function isDivisibleBy(year: number, divisor: number) {
    return year % divisor === 0
}
