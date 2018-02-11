export default class Say {
    private numberNames = [
        {value: 12, name: 'twelve', ty: '', teen: ''},
        {value: 11, name: 'eleven', ty: '', teen: ''},
        {value: 10, name: 'ten', ty: '', teen: ''},
        {value: 9, name: 'nine', ty: 'nine', teen: 'nine'},
        {value: 8, name: 'eight', ty: 'eigh', teen: 'eigh'},
        {value: 7, name: 'seven', ty: 'seven', teen: 'seven'},
        {value: 6, name: 'six', ty: 'six', teen: 'six'},
        {value: 5, name: 'five', ty: 'fif', teen: 'fif'},
        {value: 4, name: 'four', ty: 'for', teen: 'four'},
        {value: 3, name: 'three', ty: 'thir', teen: 'thir'},
        {value: 2, name: 'two', ty: 'twen', teen: ''},
        {value: 1, name: 'one', ty: '', teen: ''},
    ]

    private transforms = [
        this.higher(1000 * 1000 * 1000, 'billion'),
        this.higher(1000 * 1000, 'million'),
        this.higher(1000, 'thousand'),
        this.higher(100, 'hundred'),
        this.lower(20, this.getTenName),
        this.lower(13, this.getTeenName),
        this.lower(1, this.getSmallNumberName),
    ]

    inEnglish(input: number) {
        const translation = this.transforms.reduce(
            (translation, transform) => transform(translation),
            {remainingInput: input, result: []})
        return translation.result.join(' ') || 'zero'
    }

    private higher(multiplier: number, multiplierName: string) {
        return (translation: { remainingInput: number; result: string[] }) => {
            let {remainingInput, result} = translation
            if (remainingInput < multiplier) {
                return translation
            }
            const numberName = this.inEnglish(remainingInput / multiplier)
            result = result.concat(`${numberName} ${multiplierName}`)
            remainingInput %= multiplier
            return {remainingInput, result}
        }
    }

    private lower(minimum: number, getNameFunc: (input: number) => string) {
        return (translation: { remainingInput: number; result: string[] }) => {
            if (translation.remainingInput < minimum) {
                return translation
            }
            const name = getNameFunc.bind(this)(translation.remainingInput)
            const result = translation.result.concat(name)
            return {remainingInput: 0, result}
        }
    }

    private getSmallNumberName(input: number) {
        const singleNumber = this.getNumberName(input)
        return singleNumber.name
    }

    private getTeenName(input: number) {
        const teenNumber = this.getNumberName(input % 10)
        return teenNumber.teen + 'teen'
    }

    private getTenName(input: number) {
        const tenNumber = this.getNumberName(input / 10)
        let ten = [tenNumber.ty + 'ty']
        if (input % 10 !== 0) {
            ten = ten.concat(this.inEnglish(input % 10))
        }
        return ten.join('-')
    }

    private getNumberName(input: number) {
        const integerInput = Math.trunc(input)
        const [numberName] = this.numberNames
            .filter((n) => n.value === integerInput)
        if (numberName === undefined) {
            throw `could not find number for ${integerInput}.`
        }
        return numberName
    }
}