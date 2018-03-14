module Beer
  ( song
  ) where

import Text.Printf (printf)

verse :: Int -> String
verse n = unlines [firstLine, secondLine, ""]
  where
    firstLine = beersOnTheWall n ++ ", " ++ beers n ++ "."
    secondLine = takeOne n ++ " and pass it around, " ++ beersOnTheWall (n - 1) ++ "."
    beersOnTheWall n = beers n ++ " on the wall"
    beers n = howMany n ++ " of beer"
    takeOne n = "Take one down"
    howMany n
      | n == 0 = "no more bottles"
      | n == 1 = "1 bottle"
      | otherwise = printf "%d bottles" n

song :: String
song =
  concatMap verse [99,98 .. 2] ++
  "1 bottle of beer on the wall, 1 bottle of beer.\n\
       \Take it down and pass it around, no more bottles of beer on the wall.\n\
       \\n\
       \No more bottles of beer on the wall, no more bottles of beer.\n\
       \Go to the store and buy some more, 99 bottles of beer on the wall.\n"