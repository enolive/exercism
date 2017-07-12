import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Ignore
import org.junit.Test

class TriangleTest {

    @Test
    fun `equilateral if all sides are equal`() {
        assertThat(Triangle(2, 2, 2).isEquilateral).isTrue()
    }

    @Test
    fun `not equilateral if any side is unequal`() {
        assertThat(Triangle(2, 3, 2).isEquilateral).isFalse()
        assertThat(Triangle(2, 2, 3).isEquilateral).isFalse()
        assertThat(Triangle(3, 2, 2).isEquilateral).isFalse()
    }

    @Test
    fun `not equilateral if no sides are equal`() {
        assertThat(Triangle(5, 4, 6).isEquilateral).isFalse()
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
        assertThat(Triangle(0.5, 0.5, 0.5).isEquilateral).isTrue()
    }

    @Test
    fun isoscelesIfLastTwoSidesAreEqual() {
        assertThat(Triangle(3, 4, 4).isIsosceles).isTrue()
    }

    @Ignore
    @Test
    fun isoscelesIfFirstTwoSidesAreEqual() {
        assertThat(Triangle(4, 4, 3).isIsosceles).isTrue()
    }

    @Ignore
    @Test
    fun isoscelesIfFirstAndLastSidesAreEqual() {
        assertThat(Triangle(4, 3, 4).isIsosceles).isTrue()
    }

    @Ignore
    @Test
    fun equilateralIsAlsoIsosceles() {
        assertThat(Triangle(4, 4, 4).isIsosceles).isTrue()
    }

    @Ignore
    @Test
    fun notIsoscelesIfNoSidesAreEqual() {
        assertThat(Triangle(2, 3, 4).isIsosceles).isFalse()
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotIsosceles() {
        assertThat(Triangle(1, 1, 3).isIsosceles).isFalse()
    }

    @Ignore
    @Test
    fun isoscelesSidesMayBeFloatingPoint() {
        assertThat(Triangle(0.5, 0.4, 0.5).isIsosceles).isTrue()
    }

    @Ignore
    @Test
    fun scaleneIfNoSidesAreEqual() {
        assertThat(Triangle(5, 4, 6).isScalene).isTrue()
    }

    @Ignore
    @Test
    fun notScaleneIfAllSidesAreEqual() {
        assertThat(Triangle(4, 4, 4).isScalene).isFalse()
    }

    @Ignore
    @Test
    fun notScaleneIfTwoSidesAreEqual() {
        assertThat(Triangle(4, 4, 3).isScalene).isFalse()
    }

    @Ignore
    @Test(expected = IllegalArgumentException::class)
    fun sidesViolateTriangleInequalitySoNotScalene() {
        assertThat(Triangle(7, 3, 2).isScalene).isFalse()
    }

    @Ignore
    @Test
    fun scaleneSidesMayBeFloatingPoint() {
        assertThat(Triangle(0.5, 0.4, 0.6).isScalene).isTrue()
    }

}

