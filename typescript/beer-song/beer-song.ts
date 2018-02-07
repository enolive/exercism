const MAX_BOTTLES = 99
const SINGLE_BOTTLE = 1
const NO_BOTTLES = 0

export default class Beer {

    static sing(start: number = MAX_BOTTLES, end: number = NO_BOTTLES) {
        return this.from(start)
            .to(end)
            .map((i) => this.verse(i))
            .join('\n')
    }

    static verse(verseNumber: number) {
        return [
            this.firstSentence(verseNumber),
            this.secondSentence(verseNumber)]
            .join('\n') + '\n'
    }

    private static firstSentence(bottles: number) {
        const currentBottles = this.bottles(bottles)
        return this.capitalizeFirstLetter(`${currentBottles} on the wall, ${currentBottles}.`)
    }

    private static secondSentence(bottles: number) {
        return bottles === NO_BOTTLES
            ? `Go to the store and buy some more, ${this.bottles(MAX_BOTTLES)} on the wall.`
            : `Take ${this.takeItOrOne(bottles)} down and pass it around, ${this.bottles(bottles - 1)} on the wall.`
    }

    private static capitalizeFirstLetter(sentence: string) {
        return sentence.charAt(0).toUpperCase() + sentence.slice(1)
    }

    private static takeItOrOne(bottles: number) {
        return bottles === SINGLE_BOTTLE ? 'it' : `one`
    }

    private static bottles(count: number) {
        const howMany = count === NO_BOTTLES ? 'no more' : count
        const pluralNoun = count === SINGLE_BOTTLE ? '' : 's'
        return `${howMany} bottle${pluralNoun} of beer`
    }

    private static from(start: number) {
        return {
            to: (end: number) => Array.from({length: start - end + 1}, (_, i) => start - i)
        }
    }
}