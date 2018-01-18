export default class PhoneNumber {
    private phone: string

    constructor(phone: string) {
        this.phone = PhoneNumber.clean(phone)
    }

    number(): string | undefined {
        return !this.valid()
            ? undefined
            : this.phone
    }

    private static clean(phone: string) {
        return this.removeCountryCode(this.removePunctuation(phone))
    }

    private static removeCountryCode(phone: string) {
        return phone.length === 11 && phone.startsWith('1')
            ? phone.substring(1)
            : phone
    }

    private static removePunctuation(phone: string) {
        return phone.replace(/[()\- .]/g, '')
    }

    private valid() {
        return this.phone.length > 9 && this.phone.length < 11
    }
}