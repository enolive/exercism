module School
  ( School
  , add
  , empty
  , grade
  , sorted
  ) where

import Data.Map (Map)
import qualified Data.Map as Map

newtype School = School
  { grades :: Map Int [String]
  }

add :: Int -> String -> School -> School
add gradeNum student school = empty -- School $ Map.insertWith (++) gradeNum student $ grades school

empty :: School
empty = School Map.empty

grade :: Int -> School -> [String]
grade gradeNum school = error "You need to implement this function."

sorted :: School -> [(Int, [String])]
sorted school = error "You need to implement this function."