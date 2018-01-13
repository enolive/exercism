export default class LinkedList<T> {
    private last: Node<T>

    push(item: T) {
        this.last = new Node<T>(item, this.last)
    }

    pop(): T {
        const lastItem = this.last.value
        this.last = this.last.previous
        return lastItem
    }
}

class Node<T> {
    constructor(value: T, previous: Node<T>) {
        this._value = value
        this._previous = previous
    }

    private _value: T

    get value(): T {
        return this._value
    }

    private _previous: Node<T>

    get previous(): Node<T> {
        return this._previous
    }
}