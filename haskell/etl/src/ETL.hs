module ETL
  ( transform
  ) where

import Data.Char (toLower)
import Data.Map (Map)
import qualified Data.Map as Map

transform :: Map a String -> Map Char a
transform = Map.fromList . Map.foldlWithKey transform' []

transform' :: [(Char, a)] -> a -> String -> [(Char, a)]
transform' list points chars = list ++ map (`makeScore` points) chars

makeScore :: Char -> a -> (Char, a)
makeScore char points = (toLower char, points)