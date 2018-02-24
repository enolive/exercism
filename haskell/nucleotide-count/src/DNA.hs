module DNA
  ( nucleotideCounts
  ) where

import Data.Map
import qualified Data.Map as Map

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs
  | length empty /= Map.size nucleotideMap = Left "Invalid input"
  | otherwise = Right nucleotideMap
  where
    empty = [('A', 0), ('C', 0), ('G', 0), ('T', 0)]
    nucleotides = [(n, 1) | n <- xs]
    nucleotideMap = Map.fromListWith (+) $ nucleotides ++ empty