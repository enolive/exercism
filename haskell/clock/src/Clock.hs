module Clock (fromHourMin, toString) where

import Text.Printf (printf)

newtype Clock = Clock Integer deriving (Eq)

instance Show Clock where
  show = toString

instance Num Clock where
  Clock x + Clock y = mkClock (x + y)
  fromInteger = mkClock
  negate (Clock x) = mkClock (minsPerDay - x)

mkClock :: Integer -> Clock
mkClock x = Clock (x `mod` minsPerDay)

minsPerDay :: Integer
minsPerDay = 24 * 60

fromHourMin :: Int -> Int -> Clock
fromHourMin hour min = fromIntegral totalMins
  where
    totalMins = hour * 60 + min

toString :: Clock -> String
toString clock@(Clock x) = printf "%02d:%02d" hours mins
  where
    (hours, mins) = x `divMod` 60
