export default class BinarySearchTree {
    constructor(data: number) {
        this._data = data
    }

    private _right: BinarySearchTree

    get right(): BinarySearchTree {
        return this._right
    }

    private _left: BinarySearchTree

    get left(): BinarySearchTree {
        return this._left
    }

    private _data: number

    get data(): number {
        return this._data
    }

    insert(data: number) {
        if (data > this.data) {
            this._right = BinarySearchTree.insertOrCreate(data, this._right)
        }
        else {
            this._left = BinarySearchTree.insertOrCreate(data, this._left)
        }
    }

    each(action: (data: number) => void) {
        BinarySearchTree.callEachOn(this._left, action)
        action(this.data)
        BinarySearchTree.callEachOn(this._right, action)
    }

    private static callEachOn(node: BinarySearchTree, action: (data: number) => void) {
        if (node) {
            node.each(action)
        }
    }

    private static insertOrCreate(data: number, node: BinarySearchTree) {
        if (!node) {
            return new BinarySearchTree(data)
        }
        node.insert(data)
        return node
    }
}
