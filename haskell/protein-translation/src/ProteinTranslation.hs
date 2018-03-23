module ProteinTranslation(proteins) where

import Data.List (unfoldr)

proteins :: String -> Maybe [String]
proteins p
  | (not . null) protein' = Just [protein']
  | otherwise = Just []
  where
    protein' = protein p

protein :: String -> String
protein "AUG" = "Methionine"
protein "UUU" = "Phenylalanine"
protein "UUC" = "Phenylalanine"
protein "UUA" = "Leucine"
protein "UUG" = "Leucine"
protein "UCU" = "Serine"
protein "UCC" = "Serine"
protein "UCA" = "Serine"
protein "UCG" = "Serine"
protein "UAU" = "Tyrosine"
protein "UAC" = "Tyrosine"
protein "UGU" = "Cysteine"
protein "UGC" = "Cysteine"
protein "UGG" = "Tryptophan"
protein "UAA" = []
protein "UAG" = []
protein "UGA" = []

chunks :: Int -> [a] -> [[a]]
chunks n = takeWhile (not . null) . unfoldr (Just . splitAt n)