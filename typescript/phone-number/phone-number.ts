export default class PhoneNumber {
    private phone: string | undefined

    constructor(phone: string) {
        this.phone = PhoneNumber
            .apply(
                PhoneNumber.removePunctuation,
                PhoneNumber.removeCountryCode,
                PhoneNumber.invalidateIncorrect)
            .to(phone)
    }

    number(): string | undefined {
        return this.phone
    }

    private static apply(...functions: Array<(phone: string) => string | undefined>) {
        return {
            to: (phone: string) =>
                functions.reduce(
                    (current, func) => PhoneNumber.callOnDefinedValue(func, current),
                    phone)
        }
    }

    private static callOnDefinedValue(func: (phone: string) => string | undefined,
                                      current: string | undefined): string | undefined {
        return current !== undefined ? func(current) : undefined
    }

    private static removeCountryCode(phone: string) {
        return phone.length === 11 && phone.startsWith('1')
            ? phone.substring(1)
            : phone
    }

    private static removePunctuation(phone: string) {
        return phone.replace(/[()\- .]/g, '')
    }

    private static invalidateIncorrect(phone: string) {
        return phone.length > 9 && phone.length < 11 && phone.match(/^\d+$/)
            ? phone
            : undefined
    }
}