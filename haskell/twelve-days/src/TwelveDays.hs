module TwelveDays (recite) where

import Data.List (intercalate)

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse n = "On the " ++ nth n ++ " day of Christmas my true love gave to me, " ++ presentList n ++ "."

nth :: Int -> String
nth n = case n of
  1 -> "first"
  2 -> "second"
  3 -> "third"
  4 -> "fourth"
  5 -> "fifth"

present :: Int -> String
present n = case n of
  1 -> "a Partridge in a Pear Tree"
  2 -> "two Turtle Doves"
  3 -> "three French Hens"
  4 -> "four Calling Birds"
  5 -> "five Gold Rings"

presentList :: Int -> String
presentList = joinWithCommas . reverse . map present . enumFromTo 1

joinWithCommas :: [String] -> String
joinWithCommas [x] = x
joinWithCommas xs = intercalate ", " (init xs) ++ ", and " ++ last xs

