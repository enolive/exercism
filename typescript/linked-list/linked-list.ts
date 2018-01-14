export default class LinkedList<T> {
    private last: Node<T>
    private first: Node<T>

    shift(): T {
        const firstItem = this.first.value
        this.first = this.first.next
        return firstItem
    }

    unshift(item: T) {
        const node = new Node<T>(item)
        if (this.first) {
            this.first.previous = node
            node.next = this.first
        }
        this.first = node
        if (!this.last) {
            this.last = node
        }
    }

    push(item: T) {
        const node = new Node<T>(item)
        if (this.last) {
            this.last.next = node
            node.previous = this.last
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
    constructor(value: T) {
        this._value = value
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

    set previous(value: Node<T>) {
        this._previous = value
    }
}