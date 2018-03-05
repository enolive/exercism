module ETL
  ( transform
  ) where

import Control.Arrow (first)
import Data.Char (toLower)
import Data.Map (Map)
import qualified Data.Map as Map

transform :: Map Int String -> Map Char Int
transform = Map.fromList . transformList . Map.toList

transformList :: [(Int, String)] -> [(Char, Int)]
transformList xs = map (first toLower) $ map flipPair xs >>= splitKey

flipPair :: (a, b) -> (b, a)
flipPair (a, b) = (b, a)

splitKey :: ([a], b) -> [(a, b)]
splitKey (list, v) = map (\key -> (key, v)) list