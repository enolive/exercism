export default class Beer {

    static verse(verseNumber: number) {
        return `${this.firstSentence(verseNumber)}
${this.secondSentence(verseNumber)}.
`
    }

    private static secondSentence(verseNumber: number) {
        if (verseNumber === 0) {
            return `Go to the store and buy some more, ${this.bottles(99)} on the wall`
        }
        const remainingBottles = this.bottles(verseNumber - 1)
        const takeIt = this.takeIt(verseNumber)
        const secondSentence = `Take ${takeIt} down and pass it around, ${remainingBottles} on the wall`
        return secondSentence
    }

    private static firstSentence(verseNumber: number) {
        const currentBottles = this.bottles(verseNumber)
        const firstSentence = `${currentBottles} on the wall, ${currentBottles}.`
        return this.capitalizeFirstLetter(firstSentence)
    }

    private static capitalizeFirstLetter(sentence: string) {
        return sentence.charAt(0).toUpperCase() + sentence.slice(1)
    }

    private static takeIt(verseNumber: number) {
        return verseNumber === 1 ? 'it' : `one`
    }

    private static bottles(numberOfBottles: number) {
        if (numberOfBottles === 0) {
            return 'no more bottles of beer'
        }
        if (numberOfBottles === 1) {
            return '1 bottle of beer'
        }
        return `${numberOfBottles} bottles of beer`
    }
}