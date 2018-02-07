const MAX_BOTTLES = 99
const SINGLE_BOTTLE = 1
const NO_BOTTLES = 0

export default class Beer {
    static sing(start: number = MAX_BOTTLES, end: number = NO_BOTTLES) {
        return Range.from(start).to(end)
            .map((i) => Beer.verse(i))
            .join('\n')
    }

    static verse(bottles: number) {
        return [SongLines.first(bottles), SongLines.second(bottles)].join('\n') + '\n'
    }
}

class SongLines {
    static first(bottles: number) {
        const currentBottles = SongLines.bottles(bottles)
        return SongLines.capitalize(`${currentBottles} on the wall, ${currentBottles}.`)
    }

    static second(bottles: number) {
        return bottles === NO_BOTTLES
            ? `Go to the store and buy some more, ${SongLines.bottles(MAX_BOTTLES)} on the wall.`
            : `Take ${SongLines.takeItOrOne(bottles)} down and pass it around, ${SongLines.bottles(bottles - 1)} on the wall.`
    }

    private static capitalize(sentence: string) {
        return sentence.charAt(0).toUpperCase() + sentence.slice(1)
    }

    private static takeItOrOne(bottles: number) {
        return bottles === SINGLE_BOTTLE ? 'it' : `one`
    }

    private static bottles(count: number) {
        const howMany = count === NO_BOTTLES ? 'no more' : count
        const pluralNoun = count === SINGLE_BOTTLE ? '' : 's'
        return `${howMany} bottle${pluralNoun} of beer`
    }
}

class Range {
    static from(start: number) {
        return {
            to: (end: number) => Array.from({length: start - end + 1}, (_, i) => start - i)
        }
    }
}
