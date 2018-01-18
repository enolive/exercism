export default class PhoneNumber {
    private phone: string

    constructor(phone: string) {
        this.phone = phone.replace(/[()\- .]/g, '')
    }

    number(): string | undefined {
        if (this.phone.length === 9) {
            return undefined
        }
        return this.phone
    }
}