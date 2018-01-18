export default class PhoneNumber {
    private phone: string

    constructor(phone: string) {
        this.phone = phone.replace(/[()\- .]/g, '')
    }

    number(): string | undefined {
        return !this.valid()
            ? undefined
            : this.phone
    }

    private valid() {
        return this.phone.length > 9 && this.phone.length < 11
    }
}