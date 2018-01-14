import LinkedList from './linked-list'

describe('LinkedList', () => {
    let list: LinkedList<number>

    beforeEach(() => list = new LinkedList<number>())

    it('add/extract elements to the end of the list with push/pop', () => {
        list.push(10)
        list.push(20)
        list.push(30)
        expect(list.pop()).toBe(30)
        expect(list.pop()).toBe(20)
        expect(list.pop()).toBe(10)
    })

    it('extract elements from the beginning of the list with shift', () => {
        list.push(10)
        list.push(20)
        list.push(30)
        expect(list.shift()).toBe(10)
        expect(list.shift()).toBe(20)
        expect(list.shift()).toBe(30)
    })

    it('add/extract elements from the beginning of the list with unshift/shift', () => {
        list.unshift(10)
        list.unshift(20)
        expect(list.shift()).toBe(20)
        expect(list.shift()).toBe(10)
    })

    xit('unshift/pop', () => {
        list.unshift(10)
        list.unshift(20)
        expect(list.pop()).toBe(10)
        expect(list.pop()).toBe(20)
    })

    xit('example', () => {
        list.push(10)
        list.push(20)
        expect(list.pop()).toBe(20)
        list.push(30)
        expect(list.shift()).toBe(10)
        list.unshift(40)
        list.push(50)
        expect(list.shift()).toBe(40)
        expect(list.pop()).toBe(50)
        expect(list.shift()).toBe(30)
    })

    xit('can count its elements', () => {
        expect(list.count()).toBe(0)
        list.push(10)
        expect(list.count()).toBe(1)
        list.push(20)
        expect(list.count()).toBe(2)
    })

    xit('sets head/tail after popping last element', () => {
        list.push(10)
        list.pop()
        list.unshift(20)
        expect(list.count()).toBe(1)
        expect(list.pop()).toBe(20)
    })

    xit('sets head/tail after shifting last element', () => {
        list.unshift(10)
        list.shift()
        list.push(20)
        expect(list.count()).toBe(1)
        expect(list.shift()).toBe(20)
    })

    xit('deletes the element with the specified value from the list', () => {
        list.push(10)
        list.push(20)
        list.push(30)
        list.delete(20)
        expect(list.count()).toBe(2)
        expect(list.pop()).toBe(30)
        expect(list.shift()).toBe(10)
    })

    xit('deletes the only element', () => {
        const list = new LinkedList<number>()
        list.push(10)
        list.delete(10)
        expect(list.count()).toBe(0)
    })

    xit('delete does not modify the list if the element is not found', () => {
        const list = new LinkedList<number>()
        list.push(10)
        list.delete(20)
        expect(list.count()).toBe(1)
    })
})
