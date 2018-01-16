export default function transform(old: { [p: string]: string[] }) {
    const firstKey = +Object.keys(old)[0]
    const firstValue = Object.values(old)[0][0].toLowerCase()
    const result: {[key: string]: number} = {}
    result[firstValue] = firstKey
    return result
}
