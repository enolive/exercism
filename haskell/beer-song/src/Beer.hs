module Beer
  ( song
  ) where

import Control.Monad (liftM2)
import Data.Char (toUpper)
import Data.List (intercalate)

song :: String
song = (interlines . map verse) [99,98 .. 0]

verse :: Int -> String
verse remaining = interlines [firstLine, secondLine, ""]
  where
    firstLine = upperCaseFirst $ beersOnTheWall remaining ++ ", " ++ beers remaining ++ "."
    secondLine = case remaining of
      0 -> "Go to the store and buy some more, " ++ beersOnTheWall (99 :: Int) ++ "."
      _ -> "Take " ++ oneOrIt ++ " down and pass it around, " ++ beersOnTheWall (remaining - 1) ++ "."
    upperCaseFirst = liftM2 (:) (toUpper . head) tail
    oneOrIt = case remaining of
      1 -> "it"
      _ -> "one"

beersOnTheWall :: Int -> String
beersOnTheWall n = beers n ++ " on the wall"

beers :: Int -> String
beers n = howMany n ++ " of beer"
  where
    howMany n =
      case n of
        0 -> "no more bottles"
        1 -> "1 bottle"
        _ -> show n ++ " bottles"

interlines :: [String] -> String
interlines =  intercalate "\n"