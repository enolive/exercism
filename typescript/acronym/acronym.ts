export default class Acronym {
    static parse = (phrase: string): string =>
        Acronym.wordsFrom(phrase)
            .map((word) => word[0].toUpperCase())
            .join('')

    private static wordsFrom = (phrase: string) =>
        (phrase.match(/[A-Z]+[a-z]*|[a-z]+/g) || [])
}
