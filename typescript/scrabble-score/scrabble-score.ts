const letters = (...whichLetters: string[]) => {
    return (letter: string) => whichLetters.some((w) => w === letter)
}

const scoringRules = [
    {score: 1, appliesTo: letters('a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't')},
    {score: 2, appliesTo: letters('d', 'g')},
    {score: 3, appliesTo: letters('b', 'c', 'm', 'p')},
    {score: 4, appliesTo: letters('f', 'h', 'v', 'w', 'y')},
    {score: 5, appliesTo: letters('k') },
    {score: 8, appliesTo: letters('j', 'x') },
    {score: 10, appliesTo: letters('q', 'z')},
]

const scoreForLetter = (letter: string) => {
    const [score] = scoringRules
        .filter((l) => l.appliesTo(letter))
        .map((l) => l.score)
    if (!score) {
        throw `unrecognized letter ${letter}`
    }
    return score
}

export default (word: string | undefined) => {
    word = word || ''
    return word.split('')
        .map((letter) => letter.toLowerCase())
        .map(scoreForLetter)
        .reduce((sum, score) => sum + score, 0)
}