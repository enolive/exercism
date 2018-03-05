module ETL
  ( transform
  ) where

import Control.Arrow (first)
import Data.Char (toLower)
import Data.Map (Map)
import qualified Data.Map as Map

transform :: Map Int String -> Map Char Int
transform = Map.fromList . Map.foldlWithKey transform' []

transform' :: [(Char, Int)] -> Int -> String -> [(Char, Int)]
transform' list points chars = list ++ map (`makeScore` points) chars

makeScore :: Char -> Int -> (Char, Int)
makeScore char points = (toLower char, points)