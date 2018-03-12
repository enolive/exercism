module TwelveDays (recite) where

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse 1 = "On the " ++ day 1 ++ " day of Christmas my true love gave to me, " ++ present 1 ++ "."
verse 2 = "On the " ++ day 2 ++ " day of Christmas my true love gave to me, " ++ present 2 ++ ", and " ++ present 1 ++ "."
verse 3 = "On the " ++ day 3 ++ " day of Christmas my true love gave to me, " ++ present 3 ++ ", " ++ present 2 ++ ", and " ++ present 1 ++ "."

day :: Int -> String
day n = case n of
  1 -> "first"
  2 -> "second"
  3 -> "third"

present :: Int -> String
present 1 = "a Partridge in a Pear Tree"
present 2 = "two Turtle Doves"
present 3 = "three French Hens"