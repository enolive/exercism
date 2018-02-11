interface Translation {
    result: string[]
    remainingInput: number
}

interface NumberName {
    value: number
    name: string
    nameTen: string
    nameTeen: string
}

type Transformation = ((translation: Translation) => Translation)

export default class Say {
    private numberNames: NumberName[] = [
        {value: 12, name: 'twelve', nameTen: '', nameTeen: ''},
        {value: 11, name: 'eleven', nameTen: '', nameTeen: ''},
        {value: 10, name: 'ten', nameTen: '', nameTeen: ''},
        {value: 9, name: 'nine', nameTen: 'nine', nameTeen: 'nine'},
        {value: 8, name: 'eight', nameTen: 'eigh', nameTeen: 'eigh'},
        {value: 7, name: 'seven', nameTen: 'seven', nameTeen: 'seven'},
        {value: 6, name: 'six', nameTen: 'six', nameTeen: 'six'},
        {value: 5, name: 'five', nameTen: 'fif', nameTeen: 'fif'},
        {value: 4, name: 'four', nameTen: 'for', nameTeen: 'four'},
        {value: 3, name: 'three', nameTen: 'thir', nameTeen: 'thir'},
        {value: 2, name: 'two', nameTen: 'twen', nameTeen: ''},
        {value: 1, name: 'one', nameTen: '', nameTeen: ''},
    ]

    private transformations: Transformation[] = [
        this.higher(1000 * 1000 * 1000, 'billion'),
        this.higher(1000 * 1000, 'million'),
        this.higher(1000, 'thousand'),
        this.higher(100, 'hundred'),
        this.lower(20, this.getTenName),
        this.lower(13, this.getTeenName),
        this.lower(1, this.getSmallNumberName),
    ]

    inEnglish(input: number): string {
        if (input < 0) {
            throw 'Number must be between 0 and 999,999,999,999.'
        }
        const translation = this.transformations.reduce(
            (translation, transform) => transform(translation),
            {remainingInput: input, result: []})
        return translation.result.join(' ') || 'zero'
    }

    private higher(multiplier: number, multiplierName: string): Transformation {
        return (translation: Translation): Translation => {
            if (translation.remainingInput < multiplier) {
                return translation
            }
            const numberName = this.inEnglish(translation.remainingInput / multiplier)
            const result = translation.result.concat(`${numberName} ${multiplierName}`)
            const remainingInput = translation.remainingInput % multiplier
            return {remainingInput, result}
        }
    }

    private lower(minimum: number, getNameFunc: (input: number) => string): Transformation {
        return (translation: Translation): Translation => {
            if (translation.remainingInput < minimum) {
                return translation
            }
            const name = getNameFunc.bind(this)(translation.remainingInput)
            const result = translation.result.concat(name)
            return {remainingInput: 0, result}
        }
    }

    private getSmallNumberName(input: number): string {
        const singleNumber = this.getNumberName(input)
        return singleNumber.name
    }

    private getTeenName(input: number): string {
        const teenNumber = this.getNumberName(input % 10)
        return teenNumber.nameTeen + 'teen'
    }

    private getTenName(input: number): string {
        const tenNumber = this.getNumberName(input / 10)
        let ten = [tenNumber.nameTen + 'ty']
        if (input % 10 !== 0) {
            ten = ten.concat(this.inEnglish(input % 10))
        }
        return ten.join('-')
    }

    private getNumberName(input: number): NumberName {
        const integerInput = Math.trunc(input)
        const [numberName] = this.numberNames
            .filter((n) => n.value === integerInput)
        if (!numberName) {
            throw `could not find number for ${integerInput}.`
        }
        return numberName
    }
}