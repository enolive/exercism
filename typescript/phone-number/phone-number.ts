export default class PhoneNumber {
    private phone: string

    constructor(phone: string) {
        this.phone = PhoneNumber
            .apply(
                PhoneNumber.removePunctuation,
                PhoneNumber.removeCountryCode)
            .to(phone)
    }

    number(): string | undefined {
        return !this.valid()
            ? undefined
            : this.phone
    }

    private static apply(...functions: Array<(phone: string) => string>) {
        return {
            to: (phone: string) =>
                functions.reduce((current, func) => func(current), phone)
        }
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
        return this.invalidateIncorrect(this.phone)
    }

    private invalidateIncorrect(phone: string) {
        return phone.length > 9 && phone.length < 11 && phone.match(/^\d+$/)
    }
}