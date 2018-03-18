module Garden
  ( Plant(..)
  , defaultGarden
  , garden
  , lookupPlants
  ) where

import Data.List (sort)
import Data.Map (Map)
import qualified Data.Map as Map
import Data.Maybe (fromMaybe)

data Plant
  = Clover
  | Grass
  | Radishes
  | Violets
  deriving (Eq, Show)

defaultGarden :: String -> Map String [Plant]
defaultGarden = garden defaultStudents
  where
    defaultStudents =
      ["Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"]

garden :: [String] -> String -> Map String [Plant]
garden students plants = Map.fromList $ zip (sort students) (groups plants)

groups :: String -> [[Plant]]
groups plants =
  case lines plants of
    [[], []] -> []
    [x1:x2:xs, y1:y2:ys] -> map translate [x1, x2, y1, y2] : groups (unlines [xs, ys])

lookupPlants :: String -> Map String [Plant] -> [Plant]
lookupPlants student garden = fromMaybe [] $ Map.lookup student garden

translate :: Char -> Plant
translate plant =
  case plant of
    'V' -> Violets
    'C' -> Clover
    'R' -> Radishes
    'G' -> Grass