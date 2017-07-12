import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class TriangleTest {

    @Test
    fun `equilateral if all sides are equal`() {
        assertTrue(Triangle(2, 2, 2).isEquilateral)
    }

    @Test
    fun `not equilateral if any side is unequal`() {
        assertFalse(Triangle(2, 3, 2).isEquilateral)
        assertFalse(Triangle(2, 2, 3).isEquilateral)
        assertFalse(Triangle(3, 2, 2).isEquilateral)
    }

    @Test
    fun `not equilateral if no sides are equal`() {
        assertFalse(Triangle(5, 4, 6).isEquilateral)
    }

    @Test
    fun `all zero sides are illegal so not equilateral`() {
        val expectedType = IllegalArgumentException::class.javaObjectType
        assertThatThrownBy({ Triangle(1, 1, 0) }).isInstanceOf(expectedType)
        assertThatThrownBy({ Triangle(1, 0, 0) }).isInstanceOf(expectedType)
        assertThatThrownBy({ Triangle(0, 0, 0) }).isInstanceOf(expectedType)
        assertThatThrownBy({ Triangle(-1, -1, -1) }).isInstanceOf(expectedType)
    }

    @Test
    fun equilateralSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.5, 0.5).isEquilateral)
    }

    @Test
    fun isoscelesIfLastTwoSidesAreEqual() {
        assertTrue(Triangle(3, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesIfFirstTwoSidesAreEqual() {
        assertTrue(Triangle(4, 4, 3).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesIfFirstAndLastSidesAreEqual() {
        assertTrue(Triangle(4, 3, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun equilateralIsAlsoIsosceles() {
        assertTrue(Triangle(4, 4, 4).isIsosceles)
    }

    @Ignore
    @Test
    fun notIsoscelesIfNoSidesAreEqual() {
        assertFalse(Triangle(2, 3, 4).isIsosceles)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotIsosceles() {
        assertFalse(Triangle(1, 1, 3).isIsosceles)
    }

    @Ignore
    @Test
    fun isoscelesSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.5).isIsosceles)
    }

    @Ignore
    @Test
    fun scaleneIfNoSidesAreEqual() {
        assertTrue(Triangle(5, 4, 6).isScalene)
    }

    @Ignore
    @Test
    fun notScaleneIfAllSidesAreEqual() {
        assertFalse(Triangle(4, 4, 4).isScalene)
    }

    @Ignore
    @Test
    fun notScaleneIfTwoSidesAreEqual() {
        assertFalse(Triangle(4, 4, 3).isScalene)
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotScalene() {
        assertFalse(Triangle(7, 3, 2).isScalene)
    }

    @Ignore
    @Test
    fun scaleneSidesMayBeFloatingPoint() {
        assertTrue(Triangle(0.5, 0.4, 0.6).isScalene)
    }

}

