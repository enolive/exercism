export default class Beer {

    static sing(start: number, end: number = 0) {
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

    private static firstSentence(verseNumber: number) {
        const currentBottles = this.bottles(verseNumber)
        return this.capitalizeFirstLetter(`${currentBottles} on the wall, ${currentBottles}.`)
    }

    private static secondSentence(verseNumber: number) {
        return verseNumber === 0
            ? `Go to the store and buy some more, ${this.bottles(99)} on the wall.`
            : `Take ${this.takeIt(verseNumber)} down and pass it around, ${this.bottles(verseNumber - 1)} on the wall.`
    }

    private static capitalizeFirstLetter(sentence: string) {
        return sentence.charAt(0).toUpperCase() + sentence.slice(1)
    }

    private static takeIt(verseNumber: number) {
        return verseNumber === 1 ? 'it' : `one`
    }

    private static bottles(numberOfBottles: number) {
        switch (numberOfBottles) {
            case 0:
                return 'no more bottles of beer'
            case 1:
                return '1 bottle of beer'
            default:
                return `${numberOfBottles} bottles of beer`
        }
    }

    private static from(start: number) {
        return {
            to: (end: number) => Array.from({length: start - end + 1}, (_, i) => start - i)
        }
    }
}