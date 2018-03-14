module Beer
  ( song
  ) where

import Text.Printf (printf)

verse :: Int -> String
verse remaining = unlines [firstLine, secondLine, ""]
  where
    firstLine = beersOnTheWall remaining ++ ", " ++ beers remaining ++ "."
    secondLine
      | remaining == 0 = "Go to the store and buy some more, " ++ beersOnTheWall (99 :: Int) ++ "."
      | otherwise = "Take " ++ oneOrIt ++ " down and pass it around, " ++ beersOnTheWall (remaining - 1) ++ "."
    beersOnTheWall n = beers n ++ " on the wall"
    beers n = howMany n ++ " of beer"
    oneOrIt
      | remaining == 1 = "it"
      | otherwise = "one"
    howMany n
      | n == 0 = "no more bottles"
      | n == 1 = "1 bottle"
      | otherwise = printf "%d bottles" n

song :: String
song =
  concatMap verse [99,98 .. 1] ++
       "No more bottles of beer on the wall, no more bottles of beer.\n\
       \Go to the store and buy some more, 99 bottles of beer on the wall.\n"