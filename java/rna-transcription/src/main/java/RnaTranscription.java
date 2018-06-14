class RnaTranscription {
    String transcribe(String dnaStrand) {
        switch (dnaStrand) {
            case "G":
                return "C";
            case "C":
                return "G";
            case "T":
                return "A";
            default:
                return "";
        }
    }
}