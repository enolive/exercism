module TwelveDays
  ( recite
  ) where

import Data.List (intercalate)
import Text.Printf (printf)

day :: Int -> (String, String)
day n = case n of
  1 -> ("first", "a Partridge in a Pear Tree")
  2 -> ("second", "two Turtle Doves")
  3 -> ("third", "three French Hens")
  4 -> ("fourth", "four Calling Birds")
  5 -> ("fifth", "five Gold Rings")
  6 -> ("sixth", "six Geese-a-Laying")
  7 -> ("seventh", "seven Swans-a-Swimming")
  8 -> ("eighth", "eight Maids-a-Milking")
  9 -> ("ninth", "nine Ladies Dancing")
  10 -> ("tenth", "ten Lords-a-Leaping")
  11 -> ("eleventh", "eleven Pipers Piping")
  12 -> ("twelfth", "twelve Drummers Drumming")

recite :: Int -> Int -> [String]
recite start stop = verse <$> [start .. stop]

verse :: Int -> String
verse n = printf "On the %s day of Christmas my true love gave to me, %s." nth gifts
  where
    nth = (fst . day) n
    gifts = giftsUpTo n

giftsUpTo :: Int -> String
giftsUpTo = joinWithCommas . reverse . map giftOfTheDay . enumFromTo 1
  where
    giftOfTheDay = snd . day

joinWithCommas :: [String] -> String
joinWithCommas [x] = x
joinWithCommas xs = intercalate ", " (init xs) ++ ", and " ++ last xs