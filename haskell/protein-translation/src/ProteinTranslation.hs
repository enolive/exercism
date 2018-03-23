module ProteinTranslation
  ( proteins
  ) where

import Data.List (unfoldr)

proteins :: String -> Maybe [String]
proteins = Just . takeWhile (not . null) . map protein . chunks 3

protein :: String -> String
protein chunk
  | chunk == "AUG" = "Methionine"
  | chunk == "UGG" = "Tryptophan"
  | chunk `elem` ["UUU", "UUC"] = "Phenylalanine"
  | chunk `elem` ["UUA", "UUG"] = "Leucine"
  | chunk `elem` ["UCU", "UCC", "UCA", "UCG"] = "Serine"
  | chunk `elem` ["UAU", "UAC"] = "Tyrosine"
  | chunk `elem` ["UGU", "UGC"] = "Cysteine"
  | chunk `elem` ["UAA", "UAG", "UGA"] = []

chunks :: Int -> [a] -> [[a]]
chunks n = takeWhile (not . null) . unfoldr (Just . splitAt n)