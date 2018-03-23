module ProteinTranslation(proteins) where

import Data.List (unfoldr)

proteins :: String -> Maybe [String]
proteins p = Just [protein p]

protein :: String -> String
protein "AUG" = "Methionine"
protein "UUU" = "Phenylalanine"
protein "UUC" = "Phenylalanine"

chunks :: Int -> [a] -> [[a]]
chunks n = takeWhile (not . null) . unfoldr (Just . splitAt n)