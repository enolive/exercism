module ProteinTranslation(proteins) where

proteins :: String -> Maybe [String]
proteins p = Just [protein p]

protein "AUG" = "Methionine"
protein "UUU" = "Phenylalanine"
