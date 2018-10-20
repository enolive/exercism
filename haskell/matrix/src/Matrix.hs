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
import qualified Data.Vector   as Vector

type RowNum = Int

type ColNum = Int

type Dimensions = (RowNum, ColNum)

newtype Test a =
  Test a

newtype Matrix a = Matrix
  { contentRows :: Vector (Vector a)
  } deriving (Eq, Show)

cols :: Matrix a -> Int
cols Matrix{..}
  | Vector.null contentRows = 0
  | otherwise = (Vector.length . Vector.head) contentRows

column :: Int -> Matrix a -> Vector a
column x Matrix{..} = fmap (Vector.! x) contentRows

flatten :: Matrix a -> Vector a
flatten Matrix {..} = (Vector.concat . Vector.toList) contentRows

fromList :: [[a]] -> Matrix a
fromList xss = Matrix content
  where
    content = (Vector.fromList . map Vector.fromList) xss

fromString :: Read a => String -> Matrix a
fromString xs = fromList list
  where
    splitted = (map words . lines) xs
    list = map (map read) splitted

reshape :: Dimensions -> Matrix a -> Matrix a
reshape (height, width) matrix = Matrix {contentRows = reshapedRows}
  where
    reshapedRows = Vector.generate width rowSlice
    flattened = flatten matrix
    rowSlice rowNum = Vector.slice (rowNum * height) height flattened

row :: Int -> Matrix a -> Vector a
row x Matrix {..} = contentRows Vector.! x

rows :: Matrix a -> Int
rows Matrix {..} = Vector.length contentRows

shape :: Matrix a -> Dimensions
shape = rows &&& cols

transpose :: Matrix a -> Matrix a
transpose matrix = Matrix transposed
  where
    transposed = Vector.generate (cols matrix) createRow
    createRow rowNum = column rowNum matrix
