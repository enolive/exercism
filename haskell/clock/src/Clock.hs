module Clock (clockHour, clockMin, fromHourMin, toString) where

import Text.Printf (printf)

newtype Clock = Clock Integer deriving (Show, Eq)

instance Num Clock where
  Clock x + Clock y = Clock (x + y)
  fromInteger = Clock
  negate (Clock x) = Clock (24 * 60 - x)

clockHour :: Clock -> Int
clockHour (Clock x) = fromInteger x `div` 60

clockMin :: Clock -> Int
clockMin (Clock x) = fromInteger x `mod` 60

fromHourMin :: Int -> Int -> Clock
fromHourMin hour min = fromIntegral totalMins
  where
    totalMins = hour * 60 + min

toString :: Clock -> String
toString clock@(Clock x) = printf "%02d:%02d" hours mins
  where
    hours = clockHour clock
    mins = clockMin clock
