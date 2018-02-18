module DNA (toRNA) where

toRNA :: String -> Maybe String
toRNA xs = Just [transform x | x <- xs]
  where
    transform :: Char -> Char
    transform 'C' = 'G'
    transform 'G' = 'C'
    transform 'T' = 'A'
    transform 'A' = 'U'
