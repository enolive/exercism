module Atbash
  ( decode
  , encode
  ) where

import           Data.Char       (isAlphaNum, toLower)
import           Data.List       (intercalate)
import           Data.List.Split (chunksOf)
import           Data.Map        (Map)
import qualified Data.Map        as Map
import           Data.Maybe      (mapMaybe)

decode :: String -> String
decode = mapMaybe translate . removeSpaces

encode :: String -> String
encode = insertSpaces 5 . mapMaybe (translate . toLower)

translate :: Char -> Maybe Char
translate = (`Map.lookup` cipher)

removeSpaces :: String -> String
removeSpaces = concat . words

insertSpaces :: Integer -> String -> String
insertSpaces n = unwords . chunksOf 5

cipher :: Map Char Char
cipher = Map.fromList . zip (alphabet ++ numbers) $ (reverse alphabet ++ numbers)
  where
    alphabet = ['a' .. 'z']
    numbers = ['0' .. '9']
