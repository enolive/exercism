module Clock (clockHour, clockMin, fromHourMin, toString) where

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
toString (Clock mins) = show mins
