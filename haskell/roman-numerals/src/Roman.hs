module Roman (numerals) where

numerals :: Integer -> Maybe String
numerals n
 | n < 4 = Just $ replicate (fromInteger n) 'I'
