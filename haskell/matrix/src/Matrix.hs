{-# LANGUAGE RecordWildCards #-}

module Matrix
  ( Matrix
  , cols
  , column
  , flatten
  , fromList
  , fromString
  , reshape
  , row
  , rows
  , shape
  , transpose
  ) where

import           Control.Arrow ((&&&))
import qualified Data.List     as List (transpose)
import           Data.Vector   (Vector)
import qualified Data.Vector   as Vector (fromList, toList)


newtype Test a = Test a
newtype Matrix a = Matrix
  { allRows :: [[a]]
  } deriving (Eq, Show)

cols :: Matrix a -> Int
cols = rows . transpose

column :: Int -> Matrix a -> Vector a
column x = row x . transpose

flatten :: Matrix a -> Vector a
flatten matrix = error "You need to implement this function."

fromList :: [[a]] -> Matrix a
fromList = Matrix

fromString :: Read a => String -> Matrix a
fromString xs = Matrix allRows
  where
    splitted = (map words . lines) xs
    allRows = map (map read) splitted

reshape :: (Int, Int) -> Matrix a -> Matrix a
reshape dimensions matrix = error "You need to implement this function."

row :: Int -> Matrix a -> Vector a
row x Matrix {..} = Vector.fromList $ allRows !! x

rows :: Matrix a -> Int
rows Matrix {..} = length allRows

shape :: Matrix a -> (Int, Int)
shape = rows &&& cols

transpose :: Matrix a -> Matrix a
transpose Matrix {..} = (Matrix . List.transpose) allRows