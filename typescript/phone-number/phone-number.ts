export default class PhoneNumber {
    private phone: string
    
    constructor(phone: string) {
        this.phone = phone.replace(/[()\- .]/g, '')
    }

    number() {
        return this.phone
    }
}