export default class LinkedList<T> {
    private last: Node<T>
    private first: Node<T>

    shift(): T {
        const firstItem = this.first.value
        this.first = this.first.next
        return firstItem
    }

    push(item: T) {
        const node = new Node<T>(item, this.last)
        if (this.last) {
            this.last.next = node
        }
        this.last = node
        if (!this.first) {
            this.first = node
        }
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

    private _next: Node<T>

    get next(): Node<T> {
        return this._next
    }

    set next(value: Node<T>) {
        this._next = value
    }

    private _previous: Node<T>

    get previous(): Node<T> {
        return this._previous
    }
}