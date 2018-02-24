module School
  ( School
  , add
  , empty
  , grade
  , sorted
  ) where

import Data.Map (Map)
import qualified Data.Map as Map
import Data.Set (Set)
import qualified Data.Set as Set

type GradeNumber = Int

type Student = String

type Students = Set Student

newtype School = School
  { grades :: Map GradeNumber Students
  }

add :: GradeNumber -> Student -> School -> School
add gradeNum student school = School $ addToMap $ grades school
  where
    addToMap = Map.insertWith addStudents gradeNum $ single student

empty :: School
empty = School Map.empty

grade :: GradeNumber -> School -> [Student]
grade gradeNum school = maybe [] sortedStudents $ Map.lookup gradeNum $ grades school

sorted :: School -> [(GradeNumber, [Student])]
sorted school = [(gradeNum, grade gradeNum school) | gradeNum <- Map.keys $ grades school]

addStudents :: Students -> Students -> Students
addStudents student students = Set.union students student

sortedStudents :: Students -> [Student]
sortedStudents = Set.toAscList

single :: Student -> Students
single = Set.singleton