module DNA
  ( nucleotideCounts
  ) where

import Data.Map (Map, fromList, fromListWith)

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs
  | length empty /= length nucleotideMap = Left "Invalid input"
  | otherwise = Right nucleotideMap
  where
    empty = [('A', 0), ('C', 0), ('G', 0), ('T', 0)]
    nucleotideMap = fromListWith (+) $ [(c, 1) | c <- xs] ++ empty