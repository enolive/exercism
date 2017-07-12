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
    fun `equilateral sides may be floating point`() {
        assertThat(Triangle(0.5, 0.5, 0.5).isEquilateral).isTrue()
    }

    @Test
    fun `isosceles if last two sides are equal`() {
        assertThat(Triangle(3, 4, 4).isIsosceles).isTrue()
    }

    @Test
    fun `isosceles if first two sides are equal`() {
        assertThat(Triangle(4, 4, 3).isIsosceles).isTrue()
    }

    @Test
    fun `isosceles if first and last sides are equal`() {
        assertThat(Triangle(4, 3, 4).isIsosceles).isTrue()
    }

    @Test
    fun `equilateral is also isosceles`() {
        assertThat(Triangle(4, 4, 4).isIsosceles).isTrue()
    }

    @Test
    fun `not isosceles if no sides are equal`() {
        assertThat(Triangle(2, 3, 4).isIsosceles).isFalse()
    }

    @Test
    fun `sides violate triangle inequality so not isosceles`() {
        val expectedException = IllegalArgumentException::class.javaObjectType
        assertThatThrownBy { Triangle(1, 1, 3) }.isInstanceOf(expectedException)
        assertThatThrownBy { Triangle(3, 1, 1) }.isInstanceOf(expectedException)
        assertThatThrownBy { Triangle(1, 3, 1) }.isInstanceOf(expectedException)
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

