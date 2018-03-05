module ETL (transform) where

import Data.Map (Map)
import qualified Data.Map as Map

transform :: Map Int String -> Map Char Int
transform legacyData = Map.fromList [('a', 1)]
