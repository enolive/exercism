module Clock (clockHour, clockMin, fromHourMin, toString) where

import Text.Printf (printf)

newtype Clock = Clock Integer deriving (Show, Eq)

instance Num Clock where
  Clock x + Clock y = Clock (x + y)
  fromInteger = Clock

clockHour :: Clock -> Int
clockHour clock = error "You need to implement this function."

clockMin :: Clock -> Int
clockMin clock = error "You need to implement this function."

fromHourMin :: Int -> Int -> Clock
fromHourMin hour min = error "You need to implement this function."

toString :: Clock -> String
toString (Clock x) = printf "%02d:%02d" hours mins
  where
    (hours, mins) = x `divMod` 60
