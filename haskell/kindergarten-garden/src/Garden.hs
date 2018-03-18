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
garden students plants = Map.fromList $ zip sortedStudents studentPlants
  where
    sortedStudents = sort students
    studentPlants = map forStudent [1 ..]
    forStudent n = map translate $ concatMap (take 2 . drop (former n)) $ lines plants
    former n = (n - 1) * 2

lookupPlants :: String -> Map String [Plant] -> [Plant]
lookupPlants student garden = fromMaybe [] $ Map.lookup student garden

translate :: Char -> Plant
translate plant =
  case plant of
    'V' -> Violets
    'C' -> Clover
    'R' -> Radishes
    'G' -> Grass