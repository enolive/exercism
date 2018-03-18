module ComplexNumbers
(Complex,
 conjugate,
 abs,
 real,
 imaginary,
 mul,
 add,
 sub,
 div,
 complex) where

import Prelude hiding (div, abs)

-- Data definition -------------------------------------------------------------
data Complex a = Complex {
  real :: a,
  imaginary :: a
} deriving(Eq, Show)

complex :: (a, a) -> Complex a
complex (real, imaginary) = Complex real imaginary

-- unary operators -------------------------------------------------------------
conjugate :: Num a => Complex a -> Complex a
conjugate = error "You need to implement this function"

abs :: Floating a => Complex a -> a
abs = error "You need to implement this function"

-- binary operators ------------------------------------------------------------
mul :: Num a => Complex a -> Complex a -> Complex a
mul = error "You need to implement this function"

add :: Num a => Complex a -> Complex a -> Complex a
add = error "You need to implement this function"

sub :: Num a => Complex a -> Complex a -> Complex a
sub = error "You need to implement this function"

div :: Fractional a => Complex a -> Complex a -> Complex a
div = error "You need to implement this function"
