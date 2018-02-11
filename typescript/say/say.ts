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

        translation = this.higher(translation, 1000000, 'million')
        translation = this.higher(translation, 1000, 'thousand')
        translation = this.higher(translation, 100, 'hundred')
        translation = this.tens(translation)
        translation = this.teens(translation)
        translation = this.small(translation)

        return translation.result.join(' ') || 'zero'
    }

    private small(translation: { remainingInput: number, result: string[] }) {
        let {remainingInput, result} = translation
        if (remainingInput > 0) {
            const singleNumber = this.getNumberName(remainingInput)
            result = result.concat(singleNumber.name)
            remainingInput = 0
        }
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

    private higher(parameters: { remainingInput: number, result: string[] }, multiplier: number, multiplierName: string) {
        let {remainingInput, result} = parameters
        if (remainingInput >= multiplier) {
            const thousandNumber = this.getNumberName(remainingInput / multiplier)
            result = result.concat(`${thousandNumber.name} ${multiplierName}`)
            remainingInput -= thousandNumber.value * multiplier
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