import calculatePrimeFactors, {isPrime, letThereBePrimes} from "./prime-factors"

describe("calculatePrimeFactors", () => {
    fdescribe("primes", () => {
        it("2 is a prime", () => expect(isPrime(2)).toEqual(true))

        it("3 is a prime", () => expect(isPrime(3)).toEqual(true))

        it("4 is not a prime", () => expect(isPrime(4)).toEqual(false))

        it("returns an empty array for 1", () => expect(letThereBePrimes(1)).toEqual([]))

        it("returns 2 for 2", () => expect(letThereBePrimes(2)).toEqual([2]))

        it("returns 2,3 for 3", () => expect(letThereBePrimes(3)).toEqual([2, 3]))

        it("returns 2,3,5 for 5", () => expect(letThereBePrimes(5)).toEqual([2, 3, 5]))

        it("returns 2,3,5,7 for 7", () => expect(letThereBePrimes(7)).toEqual([2, 3, 5, 7]))

        it("returns 2,3,5,7,11,13 for 16", () => expect(letThereBePrimes(16)).toEqual([2, 3, 5, 7, 11, 13]))
    })

    it("returns an empty array for 1", () => expect(calculatePrimeFactors(1)).toEqual([]))

    it("factors 2", () => expect(calculatePrimeFactors(2)).toEqual([2]))

    it("factors 3", () => expect(calculatePrimeFactors(3)).toEqual([3]))

    it("factors 4", () => expect(calculatePrimeFactors(4)).toEqual([2, 2]))

    it("factors 6", () => expect(calculatePrimeFactors(6)).toEqual([2, 3]))

    it("factors 8", () => expect(calculatePrimeFactors(8)).toEqual([2, 2, 2]))

    it("factors 9", () => expect(calculatePrimeFactors(9)).toEqual([3, 3]))

    it("factors 27", () => expect(calculatePrimeFactors(27)).toEqual([3, 3, 3]))

    it("factors 625", () => expect(calculatePrimeFactors(625)).toEqual([5, 5, 5, 5]))

    xit("factors 901255", () => expect(calculatePrimeFactors(901255)).toEqual([5, 17, 23, 461]))

    xit("factors 93819012551", () => expect(calculatePrimeFactors(93819012551)).toEqual([11, 9539, 894119]))
})