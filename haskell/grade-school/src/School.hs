module School
  ( School
  , add
  , empty
  , grade
  , sorted
  ) where

import Data.List (sort)
import Data.Map (Map)
import qualified Data.Map as Map
import Data.Maybe
import Data.Set (Set)
import qualified Data.Set as Set

newtype School = School
  { grades :: Map Int (Set String)
  }

add :: Int -> String -> School -> School
add gradeNum student school = School $ addToMap $ grades school
  where
    addToMap = Map.insertWith Set.union gradeNum (Set.singleton student)

empty :: School
empty = School Map.empty

grade :: Int -> School -> [String]
grade gradeNum school = maybe [] Set.toAscList $ Map.lookup gradeNum $ grades school

sorted :: School -> [(Int, [String])]
sorted school = [(gradeNum, grade gradeNum school) | gradeNum <- Map.keys $ grades school]