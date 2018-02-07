export default class Beer {

    static verse(verseNumber: number) {
        const currentBottles = this.bottlesWord(verseNumber)
        const remainingBottles = this.bottlesWord(verseNumber - 1)
        const takeIt = this.takeIt(verseNumber)
        return `${currentBottles} on the wall, ${currentBottles}.
Take ${takeIt} down and pass it around, ${remainingBottles} on the wall.
`
    }

    private static takeIt(verseNumber: number) {
        return verseNumber === 1 ? 'it' : `one`
    }

    private static bottlesWord(numberOfBottles: number) {
        if (numberOfBottles === 0) {
            return 'no more bottles of beer'
        }
        if (numberOfBottles === 1) {
            return '1 bottle of beer'
        }
        return `${numberOfBottles} bottles of beer`
    }
}