module TwelveDays (recite) where

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse 1 = "On the " ++ day 1 ++ " day of Christmas my true love gave to me, a Partridge in a Pear Tree."
verse 2 = "On the " ++ day 2 ++ " day of Christmas my true love gave to me, two Turtle Doves, and a Partridge in a Pear Tree."
verse 3 = "On the " ++ day 3 ++ " day of Christmas my true love gave to me, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."

day n = case n of
  1 -> "first"
  2 -> "second"
  3 -> "third"