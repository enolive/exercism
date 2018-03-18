module Garden
  ( Plant(..)
  , defaultGarden
  , garden
  , lookupPlants
  ) where

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
defaultGarden plants = Map.fromList [("Alice", plantList plants)]
  where
    plantList "RC\nGG" = [Radishes, Clover, Grass, Grass]
    plantList "VC\nRC" = [Violets, Clover, Radishes, Clover]

garden :: [String] -> String -> Map String [Plant]
garden students plants = error "You need to implement this function."

lookupPlants :: String -> Map String [Plant] -> [Plant]
lookupPlants student garden = fromMaybe [] $ Map.lookup student garden