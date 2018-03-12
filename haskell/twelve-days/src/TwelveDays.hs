module TwelveDays (recite) where

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse n = "On the " ++ day n ++ " day of Christmas my true love gave to me, " ++ presentList n ++ "."

day :: Int -> String
day n = case n of
  1 -> "first"
  2 -> "second"
  3 -> "third"

presentList :: Int -> String
presentList 1 = present 1
presentList 2 = present 2 ++ ", and " ++ present 1
presentList 3 = present 3 ++ ", " ++ present 2 ++ ", and " ++ present 1

present :: Int -> String
present 1 = "a Partridge in a Pear Tree"
present 2 = "two Turtle Doves"
present 3 = "three French Hens"