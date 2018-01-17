export default class Acronym {
    static parse(phrase: string): string {
        return phrase
            .split('')
            .filter((letter, index) => this.startsNewWord(phrase, letter, index))
            .map((word) => word.toUpperCase())
            .join('')
    }

    private static startsNewWord(phrase: string, letter: string, index: number) {
        return letter.match(/[A-Z]/) || phrase.charAt(index - 1) === ' '
    }
}
