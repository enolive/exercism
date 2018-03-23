module ProteinTranslation
  ( proteins
  ) where

import Data.List (unfoldr)
import Data.List.Split (chunksOf)

proteins :: String -> Maybe [String]
proteins = Just . takeWhile (not . null) . map protein . chunksOf 3

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