export default class Say {

    inEnglish(input: number) {
        const numbers = [
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
        let result: string[] = []
        if (input >= 20) {
            const [tenNumber] = numbers
                .filter((n) => n.value === Math.floor(input / 10))
            result = result.concat(tenNumber.ty + 'ty')
            input -= tenNumber.value * 10
        }

        if (input >= 13) {
            const [teenNumber] = numbers
                .filter((n) => n.value === input % 10)
            result = result.concat(teenNumber.teen + 'teen')
            input -= teenNumber.value + 10
        }

        if (input > 0) {
            const [singleNumber] = numbers
                .filter((n) => n.value === Math.floor(input / 1))
            result = result.concat(singleNumber.name)
            input -= singleNumber.value * 1
        }
        return result.join('-') || 'zero'
    }
}