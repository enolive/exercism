import Say from './say'

describe('say', () => {
    const say = new Say()
    it('zero', () => {
        expect(say.inEnglish(0)).toBe('zero')
    })

    it('numbers under ten', () => {
        expect(say.inEnglish(1)).toBe('one')
        expect(say.inEnglish(2)).toBe('two')
        expect(say.inEnglish(3)).toBe('three')
        expect(say.inEnglish(4)).toBe('four')
        expect(say.inEnglish(5)).toBe('five')
        expect(say.inEnglish(6)).toBe('six')
        expect(say.inEnglish(7)).toBe('seven')
        expect(say.inEnglish(8)).toBe('eight')
        expect(say.inEnglish(9)).toBe('nine')
    })

    it('numbers between 10 and 12', () => {
        expect(say.inEnglish(10)).toBe('ten')
        expect(say.inEnglish(11)).toBe('eleven')
        expect(say.inEnglish(12)).toBe('twelve')
    })

    it('numbers between 13 and 19', () => {
        expect(say.inEnglish(13)).toBe('thirteen')
        expect(say.inEnglish(14)).toBe('fourteen')
        expect(say.inEnglish(15)).toBe('fifteen')
        expect(say.inEnglish(16)).toBe('sixteen')
        expect(say.inEnglish(17)).toBe('seventeen')
        expect(say.inEnglish(18)).toBe('eighteen')
        expect(say.inEnglish(19)).toBe('nineteen')
    })

    it('multiples of ten', () => {
        expect(say.inEnglish(20)).toBe('twenty')
        expect(say.inEnglish(30)).toBe('thirty')
        expect(say.inEnglish(40)).toBe('forty')
        expect(say.inEnglish(50)).toBe('fifty')
        expect(say.inEnglish(60)).toBe('sixty')
        expect(say.inEnglish(70)).toBe('seventy')
        expect(say.inEnglish(80)).toBe('eighty')
        expect(say.inEnglish(90)).toBe('ninety')
    })

    it('numbers between 20 and 99', () => {
        expect(say.inEnglish(22)).toBe('twenty-two')
        expect(say.inEnglish(42)).toBe('forty-two')
        expect(say.inEnglish(99)).toBe('ninety-nine')
    })

    it('numbers that are multiples of 100', () => {
        expect(say.inEnglish(100)).toBe('one hundred')
        expect(say.inEnglish(200)).toBe('two hundred')
        expect(say.inEnglish(300)).toBe('three hundred')
    })

    it('combined hundreds with lower numbers', () => {
        expect(say.inEnglish(123)).toBe('one hundred twenty-three')
        expect(say.inEnglish(897)).toBe('eight hundred ninety-seven')
    })

    it('numbers that are multiples of 1000', () => {
        expect(say.inEnglish(1000)).toBe('one thousand')
        expect(say.inEnglish(4000)).toBe('four thousand')
    })

    it('one thousand two hundred thirty-four', () => {
        expect(say.inEnglish(1234)).toBe('one thousand two hundred thirty-four')
    })

    it('one million', () => {
        expect(say.inEnglish(1000000)).toBe('one million')
    })

    xit('one million two', () => {
        expect(say.inEnglish(1000002)).toBe('one million two')
    })

    xit('one million two thousand three hundred forty-five', () => {
        expect(say.inEnglish(1002345))
            .toBe('one million two thousand three hundred forty-five')
    })

    xit('one billion', () => {
        expect(say.inEnglish(1000000000)).toBe('one billion')
    })

    xit('a really big number', () => {
        let expected = 'nine hundred eighty-seven billion '
        expected += 'six hundred fifty-four million '
        expected += 'three hundred twenty-one thousand '
        expected += 'one hundred twenty-three'
        expect(say.inEnglish(987654321123)).toBe(expected)
    })

    xit('raises an error below zero', () => {
        expect(() => {
            say.inEnglish(-1)
        }).toThrowError('Number must be between 0 and 999,999,999,999.')
    })

    xit('raises an error above 999,999,999,999', () => {
        expect(() => {
            say.inEnglish(1000000000000)
        }).toThrowError('Number must be between 0 and 999,999,999,999.')
    })

})
