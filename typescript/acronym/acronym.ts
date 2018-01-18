export default class Acronym {
    private static startNewWordRules: [(phrase: string, index: number) => boolean] = [
        Acronym.isStartOfSentence,
        Acronym.isUpperCaseFollowingLowerCase,
        Acronym.isFormerOneOf(' ', '-')
    ]

    static parse(phrase: string): string {
        return phrase
            .split('')
            .filter((_, index) => Acronym.startsNewWord(phrase, index))
            .map((word) => word.toUpperCase())
            .join('')
    }

    private static startsNewWord(phrase: string, index: number) {
        return Acronym.startNewWordRules.some((rule) => rule(phrase, index))
    }

    // noinspection JSUnusedLocalSymbols
    private static isStartOfSentence(_: string, index: number): boolean {
        return index === 0
    }

    private static isUpperCaseFollowingLowerCase(phrase: string, index: number): boolean {
        return Acronym.isCurrentUpperCase(phrase, index) && Acronym.isFormerLowerCase(phrase, index)
    }

    private static isFormerOneOf(...characters: string[]) {
        return (phrase: string, index: number): boolean => {
            return characters.some((c) => Acronym.formerLetter(phrase, index) === c)
        }
    }

    private static isFormerLowerCase(phrase: string, index: number): boolean {
        return Acronym.formerLetter(phrase, index).match(/[a-z]/) !== null
    }

    private static isCurrentUpperCase(phrase: string, index: number): boolean {
        return Acronym.currentLetter(phrase, index).match(/[A-Z]/) !== null
    }

    private static currentLetter(phrase: string, index: number): string {
        return phrase.charAt(index)
    }

    private static formerLetter(phrase: string, index: number): string {
        return phrase.charAt(index - 1)
    }
}
