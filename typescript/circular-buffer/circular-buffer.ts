export default class CircularBuffer<T> {
    private data: T[] = []
    private capacity: number

    constructor(capacity: number) {
        this.capacity = capacity
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
        if (this.data.length >= this.capacity) {
            throw new BufferOverflowError()
        }
        this.data.push(item)
    }
}

export class BufferOverflowError implements Error {
    readonly name: string = 'BufferOverflow'
    readonly message: string = 'buffer is full'
}

export class BufferEmptyError implements Error {
    readonly name: string = 'BufferEmpty'
    readonly message: string = 'buffer is empty'
}
