const keep = <T>(array: T[], predicate: (item: T) => boolean): T[] =>
    filter(array, predicate)

const discard = <T>(array: T[], predicate: (item: T) => boolean): T[] =>
    filter(array, (item) => !predicate(item))

const filter = <T>(array: T[], predicate: (item: T) => boolean): T[] =>
    filterRec(array, [], predicate)

const filterRec = <T>(array: T[], acc: T[], predicate: (item: T) => boolean): T[] => {
    if (array.length === 0) {
        return acc
    }
    const [head, ...tail] = array
    const newAcc = predicate(head) ? [...acc, head] : acc
    return filterRec(tail, newAcc, predicate)
}

export {keep, discard}
