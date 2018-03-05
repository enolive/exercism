module ETL (transform) where

import Control.Arrow (first)
import Data.Char (toLower)
import Data.Map (Map)
import qualified Data.Map as Map

transform :: Map Int String -> Map Char Int
transform legacyData = Map.fromList $ transformList $ Map.toList legacyData

transformList xs = map (first toLower) $ swapPairs xs >>= splitCharacters
swapPairs xs = map (\ (count, characters) -> (characters, count)) xs
splitCharacters (characters, count) = [(character, count) | character <- characters]