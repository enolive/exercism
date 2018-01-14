export default class CircularBuffer<T> {
    private data: T[] = []
    private capacity: number

    constructor(capacity: number) {
        this.capacity = capacity
    }

    clear() {
        this.data.splice(0)
    }

    read(): T {
        if (this.isEmpty()) {
            throw new BufferEmptyError()
        }
        return this.data.shift()! // HINT: we are smarter than the compiler here
    }

    forceWrite(item: T) {
        if (this.isFull()) {
            this.read()
        }
        this.write(item)
    }

    write(item: T) {
        if (this.isFull()) {
            throw new BufferOverflowError()
        }
        this.data.push(item)
    }

    private isEmpty() {
        return this.data.length === 0
    }

    private isFull() {
        return this.data.length >= this.capacity
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
