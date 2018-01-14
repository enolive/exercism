export default class CircularBuffer<T> {
    constructor(capacity: number) {

    }

    read() {
        throw new BufferEmptyError()
    }
}

export class BufferEmptyError implements Error {
    name: string = 'BufferEmptyError'
    message: string = 'buffer is empty'
}
