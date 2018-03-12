module TwelveDays
  ( recite
  ) where

import Data.List (intercalate)
import Text.Printf (printf)

day :: Int -> (String, String)
day n = days !! (n - 1)
  where
    days =
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