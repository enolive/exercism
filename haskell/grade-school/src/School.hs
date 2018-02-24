module School
  ( School
  , add
  , empty
  , grade
  , sorted
  ) where

import Data.Map (Map)
import qualified Data.Map as Map
import Data.List (sort)
import Data.Maybe

newtype School = School
  { grades :: Map Int [String]
  }

add :: Int -> String -> School -> School
add gradeNum student school = School $ Map.insertWith (++) gradeNum [student] $ grades school

empty :: School
empty = School Map.empty

grade :: Int -> School -> [String]
grade gradeNum school = sort $ fromMaybe [] $ Map.lookup gradeNum $ grades school

sorted :: School -> [(Int, [String])]
sorted school = [(gradeNum, grade gradeNum school) | gradeNum <- Map.keys $ grades school]
  where
    sortByName :: [(Int, [String])] -> [(Int, [String])]
    sortByName list = [(grade, sort students) | (grade, students) <- list]