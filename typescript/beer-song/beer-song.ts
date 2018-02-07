const MAX_BOTTLES = 99
const SINGLE_BOTTLE = 1
const NO_BOTTLES = 0

export default class Beer {

    static sing = (start: number = MAX_BOTTLES, end: number = NO_BOTTLES) =>
        Range.from(start).to(end)
            .map((i) => Beer.verse(i))
            .join('\n')

    static verse = (bottles: number) =>
        [Beer.firstSentence(bottles), Beer.secondSentence(bottles)].join('\n') + '\n'

    private static firstSentence = (bottles: number) => {
        const currentBottles = Beer.bottles(bottles)
        return Beer.capitalize(`${currentBottles} on the wall, ${currentBottles}.`)
    }

    private static secondSentence = (bottles: number) =>
        bottles === NO_BOTTLES
            ? `Go to the store and buy some more, ${Beer.bottles(MAX_BOTTLES)} on the wall.`
            : `Take ${Beer.takeItOrOne(bottles)} down and pass it around, ${Beer.bottles(bottles - 1)} on the wall.`

    private static capitalize = (sentence: string) =>
        sentence.charAt(0).toUpperCase() + sentence.slice(1)

    private static takeItOrOne = (bottles: number) => {
        return bottles === SINGLE_BOTTLE ? 'it' : `one`
    }

    private static bottles = (count: number) => {
        const howMany = count === NO_BOTTLES ? 'no more' : count
        const pluralNoun = count === SINGLE_BOTTLE ? '' : 's'
        return `${howMany} bottle${pluralNoun} of beer`
    }

}

class Range {
    static from(start: number) {
        return {
            to: (end: number) => Array.from({length: start - end + 1}, (_, i) => start - i)
        }
    }
}
