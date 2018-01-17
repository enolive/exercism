export default class Acronym {
    static parse(phrase: string): string {
        return phrase.split(' ').map((word) => word.charAt(0).toUpperCase()).join('')
    }
}
