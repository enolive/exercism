module DNA (toRNA) where

toRNA :: String -> Maybe String
toRNA xs = Just $ transform xs
  where
  transform :: String -> String
  transform "C" = "G"
  transform "G" = "C"
  transform "T" = "A"
  transform "A" = "U"
