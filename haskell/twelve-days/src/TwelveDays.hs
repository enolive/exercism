module TwelveDays (recite) where

recite :: Int -> Int -> [String]
recite start stop = [verse start]

verse :: Int -> String
verse 1 = "On the first day of Christmas my true love gave to me, a Partridge in a Pear Tree."
verse 2 = "On the second day of Christmas my true love gave to me, two Turtle Doves, and a Partridge in a Pear Tree."
verse 3 = "On the third day of Christmas my true love gave to me, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree."