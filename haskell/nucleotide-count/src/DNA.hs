module DNA (nucleotideCounts) where

import Data.Map (Map, fromList)

nucleotideCounts :: String -> Either String (Map Char Int)
nucleotideCounts xs = Right $ fromList [('A', 0), ('C', 0), ('G', 0), ('T', 0)]
