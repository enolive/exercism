export default class Acronym {
    static parse(phrase: string): string {
        return phrase
            .split('')
            .filter((letter, index) => (letter.match(/[A-Z]/) || phrase.charAt(index - 1) === ' '))
            .map((word) => word.charAt(0).toUpperCase())
            .join('')
    }
}
