module School
  ( School
  , add
  , empty
  , grade
  , sorted
  ) where

import           Data.Map   (Map)
import qualified Data.Map   as Map
import           Data.Maybe (fromMaybe)
import           Data.Set   (Set)
import qualified Data.Set   as Set

type GradeNumber = Int

type Student = String

type Students = Set Student

newtype School = School
  { allGrades :: Map GradeNumber Students
  }

add :: GradeNumber -> Student -> School -> School
add gradeNum student school = School {allGrades = addToMap $ allGrades school}
  where
    addToMap :: Map GradeNumber Students -> Map GradeNumber Students
    addToMap = Map.alter (addStudent student) gradeNum
    addStudent :: Student -> Maybe Students -> Maybe Students
    addStudent student formerStudents = Just $ Set.insert student $ fromMaybe Set.empty formerStudents

empty :: School
empty = School { allGrades = Map.empty }

grade :: GradeNumber -> School -> [Student]
grade gradeNum school = maybe [] sortedStudents $ Map.lookup gradeNum $ allGrades school
  where
    sortedStudents :: Students -> [Student]
    sortedStudents = Set.toAscList

sorted :: School -> [(GradeNumber, [Student])]
sorted school = [(gradeNum, grade gradeNum school) | gradeNum <- Map.keys $ allGrades school]