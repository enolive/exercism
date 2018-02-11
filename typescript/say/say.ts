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
        let result: string[] = []
        if (input >= 20) {
            const [tenNumber] = this.numberNames
                .filter((n) => n.value === Math.floor(input / 10))
            result = result.concat(tenNumber.ty + 'ty')
            input -= tenNumber.value * 10
        }

        if (input >= 13) {
            const [teenNumber] = this.numberNames
                .filter((n) => n.value === input % 10)
            result = result.concat(teenNumber.teen + 'teen')
            input -= teenNumber.value + 10
        }

        if (input > 0) {
            const [singleNumber] = this.numberNames
                .filter((n) => n.value === input)
            result = result.concat(singleNumber.name)
            input -= singleNumber.value
        }
        return result.join('-') || 'zero'
    }
}