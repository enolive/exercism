module DNA (nucleotideCounts) where

import Data.Map (Map, fromList, fromListWith)

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs = Right $ fromListWith (+) $ [(c, 1) | c <- xs] ++ empty
  where empty = [('A', 0), ('C', 0), ('G', 0), ('T', 0)]
