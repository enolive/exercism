export default class Beer {

    static verse(verseNumber: number) {
        const currentBottles = verseNumber
        const remainingBottles = currentBottles - 1
        return `${currentBottles} bottles of beer on the wall, ${currentBottles} bottles of beer.
Take one down and pass it around, ${remainingBottles} bottles of beer on the wall.
`
    }
}