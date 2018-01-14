export default class LinkedList<T> {
    private last: Node<T> | undefined
    private first: Node<T> | undefined

    delete(item: T) {
        this.findNodesHavingValue(item)
            .forEach((n) => this.deleteNode(n))
    }

    shift(): T | undefined {
        if (!this.first) {
            return undefined
        }
        const firstItem = this.first.value
        this.first = this.first.next
        if (!this.first) {
            this.last = undefined
        }
        return firstItem
    }

    count(): number {
        const countNodes = (current: Node<T> | undefined, count: number): number =>
            !current
                ? count
                : countNodes(current.next, count + 1)
        return countNodes(this.first, 0)
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

    pop(): T | undefined {
        if (!this.last) {
            return undefined
        }
        const lastItem = this.last.value
        this.last = this.last.previous
        if (!this.last) {
            this.first = undefined
        }
        return lastItem
    }

    private findNodesHavingValue(value: T): Array<Node<T>> {
        const findNodes = (current: Node<T> | undefined, found: Array<Node<T>> = []): Array<Node<T>> => {
            if (!current) {
                return found
            }
            const newFound = current.value === value
                ? [...found, current]
                : found
            return findNodes(current.next, newFound)
        }
        return findNodes(this.first, [])
    }

    private deleteNode(current: Node<T>) {
        const previousNode = current.previous
        const nextNode = current.next
        if (previousNode) {
            previousNode.next = nextNode
        }
        else {
            this.first = nextNode
        }
        if (nextNode) {
            nextNode.previous = previousNode
        }
        else {
            this.last = previousNode
        }
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