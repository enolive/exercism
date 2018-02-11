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

    inEnglish(input: number) {
        const empty: string[] = []

        let translation = {remainingInput: input, result: empty}

        translation = this.higher(1000 * 1000 * 1000, 'billion', translation)
        translation = this.higher(1000 * 1000, 'million', translation)
        translation = this.higher(1000, 'thousand', translation)
        translation = this.higher(100, 'hundred', translation)
        translation = this.lower(translation)

        return translation.result.join(' ') || 'zero'
    }

    private higher(multiplier: number, multiplierName: string, translation: { remainingInput: number; result: string[] }) {
        let {remainingInput, result} = translation
        if (remainingInput >= multiplier) {
            const numberName = this.inEnglish(remainingInput / multiplier)
            result = result.concat(`${numberName} ${multiplierName}`)
            remainingInput %= multiplier
        }
        return {remainingInput, result}
    }

    private lower(translation: { remainingInput: number; result: string[] }) {
        translation = this.tens(translation)
        translation = this.teens(translation)
        translation = this.small(translation)
        return translation
    }

    private small(translation: { remainingInput: number, result: string[] }) {
        if (translation.remainingInput <= 0) {
            return translation
        }
        const singleNumber = this.getNumberName(translation.remainingInput)
        const result = translation.result.concat(singleNumber.name)
        const remainingInput = 0
        return {remainingInput, result}
    }

    private teens(translation: { remainingInput: number, result: string[] }) {
        let {remainingInput, result} = translation
        if (remainingInput >= 13) {
            const teenNumber = this.getNumberName(remainingInput % 10)
            result = result.concat(teenNumber.teen + 'teen')
            remainingInput = 0
        }
        return {remainingInput, result}
    }

    private tens(translation: { remainingInput: number, result: string[] }) {
        let {remainingInput, result} = translation
        if (remainingInput >= 20) {
            const tenNumber = this.getNumberName(remainingInput / 10)
            const singleNumber = this.getNumberName(remainingInput % 10)
            let ten = [tenNumber.ty + 'ty']
            if (singleNumber) {
                ten = ten.concat(singleNumber.name)
            }
            result = result.concat(ten.join('-'))
            remainingInput = 0
        }
        return {remainingInput, result}
    }

    private getNumberName(input: number) {
        const integerInput = Math.trunc(input)
        const [singleNumber] = this.numberNames
            .filter((n) => n.value === integerInput)
        return singleNumber
    }
}