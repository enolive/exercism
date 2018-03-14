module Beer
  ( song
  ) where

import Control.Monad (liftM2)
import Data.Char (toUpper)
import Data.List (intercalate)
import Text.Printf (printf)

verse :: Int -> String
verse remaining = unlines [firstLine, secondLine]
  where
    firstLine = upperCaseFirst $ beersOnTheWall remaining ++ ", " ++ beers remaining ++ "."
    secondLine
      | remaining == 0 = "Go to the store and buy some more, " ++ beersOnTheWall (99 :: Int) ++ "."
      | otherwise = "Take " ++ oneOrIt ++ " down and pass it around, " ++ beersOnTheWall (remaining - 1) ++ "."
    upperCaseFirst = liftM2 (:) (toUpper . head) tail
    oneOrIt
      | remaining == 1 = "it"
      | otherwise = "one"

beersOnTheWall :: Int -> String
beersOnTheWall n = beers n ++ " on the wall"

beers :: Int -> String
beers n = howMany n ++ " of beer"
  where
    howMany n
      | n == 0 = "no more bottles"
      | n == 1 = "1 bottle"
      | otherwise = printf "%d bottles" n

song :: String
song = (intercalate "\n" . map verse) [99,98 .. 0]