export default class CircularBuffer<T> {
    private data: T[] = []

    constructor(capacity: number) {
    }

    clear() {
        this.data.splice(0)
    }

    read() {
        if (this.data.length === 0) {
            throw new BufferEmptyError()
        }
        const [item] = this.data.splice(0, 1)
        return item
    }

    write(item: T) {
        this.data.push(item)
    }
}

export class BufferEmptyError implements Error {
    readonly name: string = 'BufferEmptyError'
    readonly message: string = 'buffer is empty'
}
