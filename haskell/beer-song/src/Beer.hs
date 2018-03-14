module Beer
  ( song
  ) where

import Text.Printf (printf)

verse :: Int -> String
verse n = unlines [firstLine, secondLine, ""]
  where
    firstLine = beersOnTheWall currentCount ++ ", " ++ beers currentCount ++ "."
    secondLine = "Take one down and pass it around, " ++ beersOnTheWall nextCount ++ "."
    beers = printf "%d bottles of beer"
    beersOnTheWall n = beers n ++ " on the wall"
    currentCount = 100 - n
    nextCount = currentCount - 1

song :: String
song =  concatMap verse [1..97] ++
       "2 bottles of beer on the wall, 2 bottles of beer.\n\
       \Take one down and pass it around, 1 bottle of beer on the wall.\n\
       \\n\
       \1 bottle of beer on the wall, 1 bottle of beer.\n\
       \Take it down and pass it around, no more bottles of beer on the wall.\n\
       \\n\
       \No more bottles of beer on the wall, no more bottles of beer.\n\
       \Go to the store and buy some more, 99 bottles of beer on the wall.\n"