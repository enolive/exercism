interface Translation {
    result: string[]
    remainingInput: number
}

type Transformation = ((translation: Translation) => Translation)

class ArgumentError extends Error {
}

export default class Say {
    private below20: string[] = [
        'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine',
        'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen',
        'seventeen', 'eighteen', 'nineteen'
    ]

    private tens: string[] = [
        'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'
    ]

    private transformations: Transformation[] = [
        this.higher(10 ** 9, 'billion'),
        this.higher(10 ** 6, 'million'),
        this.higher(1000, 'thousand'),
        this.higher(100, 'hundred'),
        this.lower(20, this.getTenName),
        this.lower(1, this.getBelow20Name),
    ]

    inEnglish(input: number): string {
        if (input < 0 || input > 10 ** 12 - 1) {
            throw new ArgumentError('Number must be between 0 and 999,999,999,999.')
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

    private getBelow20Name(input: number): string {
        return this.below20[Math.trunc(input) - 1]
    }

    private getTenName(input: number): string {
        const tenNumber = this.tens[Math.trunc(input / 10) - 2]
        return input % 10 !== 0
            ? [tenNumber].concat(this.inEnglish(input % 10)).join('-')
            : tenNumber
    }
}