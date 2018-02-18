module DNA (toRNA) where

toRNA :: String -> Maybe String
toRNA xs
  | '\NUL' `elem` rnaSequence = Nothing
  | otherwise = Just rnaSequence
  where
    rnaSequence = [rna x | x <- xs]
    rna x =
      case x of
        'C' -> 'G'
        'G' -> 'C'
        'T' -> 'A'
        'A' -> 'U'
        _ -> '\NUL'
