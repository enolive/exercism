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

type GradeNumber = Int
newtype School = School
  { grades :: Map GradeNumber (Set String)
  }

add :: GradeNumber -> String -> School -> School
add gradeNum student school = School $ addToMap $ grades school
  where
    addToMap = Map.insertWith Set.union gradeNum (Set.singleton student)

empty :: School
empty = School Map.empty

grade :: GradeNumber -> School -> [String]
grade gradeNum school = maybe [] Set.toAscList $ Map.lookup gradeNum $ grades school

sorted :: School -> [(GradeNumber, [String])]
sorted school = [(gradeNum, grade gradeNum school) | gradeNum <- Map.keys $ grades school]