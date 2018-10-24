module Triangle (rows) where

rows :: Int -> [[Integer]]
rows 0 = []
rows 1 = rows 0 ++ [[1]]
rows 2 = rows 1 ++ [[1, 1]]
rows 3 = rows 2 ++ [[1, 2, 1]]
rows 4 = rows 3 ++ [[1, 3, 3, 1]]
rows x = error "You need to implement this function."
