export default class Acronym {
    static parse(phrase: string): string {
        return phrase
            .split('')
            .filter((_, index) => this.startsNewWord(phrase, index))
            .map((word) => word.toUpperCase())
            .join('')
    }

    private static startsNewWord(phrase: string, index: number) {
        if (index === 0) {
            return true
        }
        const formerLetter = phrase.charAt(index - 1)
        const currentLetter = phrase.charAt(index)
        if (currentLetter.match(/[A-Z]/) && (formerLetter.match(/[a-z]/))) {
            return true
        }
        if (formerLetter === ' ') {
            return true
        }
        return false
    }
}
