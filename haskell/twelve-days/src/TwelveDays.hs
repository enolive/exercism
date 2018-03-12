module TwelveDays
  ( recite
  ) where

import Data.List (intercalate)

dailyPresents :: [(String, String)]
dailyPresents =
  [ ("first", "a Partridge in a Pear Tree")
  , ("second", "two Turtle Doves")
  , ("third", "three French Hens")
  , ("fourth", "four Calling Birds")
  , ("fifth", "five Gold Rings")
  , ("sixth", "six Geese-a-Laying")
  , ("seventh", "seven Swans-a-Swimming")
  , ("eighth", "eight Maids-a-Milking")
  , ("ninth", "nine Ladies Dancing")
  , ("tenth", "ten Lords-a-Leaping")
  , ("eleventh", "eleven Pipers Piping")
  , ("twelfth", "twelve Drummers Drumming")
  ]

recite :: Int -> Int -> [String]
recite start stop = verse <$> [start .. stop]

verse :: Int -> String
verse n = "On the " ++ nth n ++ " day of Christmas my true love gave to me, " ++ presentList n ++ "."

fixed :: String -> Int -> String
fixed str _ = str

nth :: Int -> String
nth = fst . daily

presentList :: Int -> String
presentList = joinWithCommas . reverse . map present . enumFromTo 1

joinWithCommas :: [String] -> String
joinWithCommas [x] = x
joinWithCommas xs = intercalate ", " (init xs) ++ ", and " ++ last xs

present :: Int -> String
present = snd . daily

daily :: Int -> (String, String)
daily n = dailyPresents !! (n - 1)