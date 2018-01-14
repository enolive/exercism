export default class CircularBuffer<T> {
    private data: T[] = []
    constructor(capacity: number) {

    }

    read() {
        if (this.data.length === 0) {
            throw new BufferEmptyError()
        }
        const [item] = this.data.splice(0)
        return item
    }

    write(item: T) {
        this.data.push(item)
    }
}

export class BufferEmptyError implements Error {
    name: string = 'BufferEmptyError'
    message: string = 'buffer is empty'
}
