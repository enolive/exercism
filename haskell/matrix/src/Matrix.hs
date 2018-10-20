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
import           Data.Vector   (Vector)
import qualified Data.Vector   as Vector (fromList)

newtype Matrix a = Matrix
  { allRows :: [[a]]
  } deriving (Eq, Show)

cols :: Matrix a -> Int
cols Matrix {allRows = []} = 0
cols Matrix {..}           = (minimum . map length) allRows

column :: Int -> Matrix a -> Vector a
column x Matrix {..} = (Vector.fromList . map (!! x)) allRows

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
transpose matrix = error "You need to implement this function."
