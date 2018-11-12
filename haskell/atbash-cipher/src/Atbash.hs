module Atbash
  ( decode
  , encode
  ) where

import           Data.Char       (isAlphaNum, toLower)
import           Data.List       (intercalate)
import           Data.List.Split (chunksOf)
import           Data.Map        (Map)
import qualified Data.Map        as Map

decode :: String -> String
decode = map translate . removeSpaces

encode :: String -> String
encode = insertSpaces 5 . map (translate . toLower) . filter isAlphaNum

removeSpaces :: String -> String
removeSpaces = concat . words

insertSpaces :: Integer -> String -> String
insertSpaces n = unwords . chunksOf 5

translate :: Char -> Char
translate k = Map.findWithDefault k k cipher

cipher :: Map Char Char
cipher = Map.fromList . zip alphabet . reverse $ alphabet
  where
    alphabet = ['a' .. 'z']
