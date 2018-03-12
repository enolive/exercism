module TwelveDays (recite) where

import Data.List (intercalate)

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse n = "On the " ++ nth n ++ " day of Christmas my true love gave to me, " ++ presentList n ++ "."

days :: [(String, String)]
days = [
  ("first", "a Partridge in a Pear Tree"),
  ("second", "two Turtle Doves"),
  ("third", "three French Hens"),
  ("fourth", "four Calling Birds"),
  ("fifth", "five Gold Rings")
  ]

presentList :: Int -> String
presentList = joinWithCommas . reverse . map present . enumFromTo 1

joinWithCommas :: [String] -> String
joinWithCommas [x] = x
joinWithCommas xs = intercalate ", " (init xs) ++ ", and " ++ last xs

nth :: Int -> String
nth = fst . day

present :: Int -> String
present = snd . day

day :: Int -> (String, String)
day n = days !! (n - 1)