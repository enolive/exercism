export default class Transcriptor {

    toRna(dna: string) {
        return dna
            .split("")
            .map(Convert.nucleotide)
            .join("")
    }

}

class Convert {
    public static nucleotide(value: string) {
        switch (value) {
            case "G":
                return "C"
            case "A":
                return "U"
            case "T":
                return "A"
            case "C":
                return "G"
            default:
                throw "Invalid input DNA."
        }
    }
}