module Meetup
  ( Weekday(..)
  , Schedule(..)
  , meetupDay
  ) where

import Data.Maybe (mapMaybe)
import Data.Time.Calendar (Day, fromGregorianValid, toGregorian)
import Data.Time.Calendar.WeekDate (toWeekDate)

data Weekday
  = Monday
  | Tuesday
  | Wednesday
  | Thursday
  | Friday
  | Saturday
  | Sunday
  deriving (Show, Eq, Enum)

data Schedule
  = First
  | Second
  | Third
  | Fourth
  | Last
  | Teenth

meetupDay :: Schedule -> Weekday -> Integer -> Int -> Day
meetupDay schedule weekday year month = (pick . filter (isDayOfWeek weekday)) $ daysOfMonth year month
  where
    pick =
      case schedule of
        First -> head
        Second -> (!! 1)
        Third -> (!! 2)
        Fourth -> (!! 3)
        Last -> last
        Teenth -> head . filter isTeen

daysOfMonth :: Integer -> Int -> [Day]
daysOfMonth year month = mapMaybe (fromGregorianValid year month) [1 .. 31]

isTeen :: Day -> Bool
isTeen day =
  let (_, _, dayOfMonth) = toGregorian day
  in dayOfMonth `elem` [13 .. 19]

isDayOfWeek :: Weekday -> Day -> Bool
isDayOfWeek weekday day = dayOfWeek day == weekday

dayOfWeek :: Day -> Weekday
dayOfWeek day =
  let (_, _, weekDay) = toWeekDate day
  in toEnum (weekDay - 1)