export function keep<Type>(array: Type[], predicate: (item: Type) => boolean): Type[] {
    const newArray = []
    for (const item of array) {
        if (!predicate(item)) {
            continue
        }
        newArray.push(item)
    }
    return newArray
}
export function discard<Type>(array: Type[], predicate: (item: Type) => boolean) {
    return array
}