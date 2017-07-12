import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.Test
import kotlin.reflect.KClass

class `Triangle Test` {

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
        val expectedException = type(IllegalArgumentException::class)
        assertThatThrownBy({ Triangle(1, 1, 0) }).isInstanceOf(expectedException)
        assertThatThrownBy({ Triangle(1, 0, 0) }).isInstanceOf(expectedException)
        assertThatThrownBy({ Triangle(0, 0, 0) }).isInstanceOf(expectedException)
        assertThatThrownBy({ Triangle(-1, -1, -1) }).isInstanceOf(expectedException)
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
        val expectedException = type(IllegalArgumentException::class)
        assertThatThrownBy { Triangle(1, 1, 3) }.isInstanceOf(expectedException)
        assertThatThrownBy { Triangle(3, 1, 1) }.isInstanceOf(expectedException)
        assertThatThrownBy { Triangle(1, 3, 1) }.isInstanceOf(expectedException)
    }

    @Test
    fun `isosceles sides may be floating point`() {
        assertThat(Triangle(0.5, 0.4, 0.5).isIsosceles).isTrue()
    }

    @Test
    fun `scalene if no sides are equal`() {
        assertThat(Triangle(5, 4, 6).isScalene).isTrue()
    }

    @Test
    fun `not scalene if all sides are equal`() {
        assertThat(Triangle(4, 4, 4).isScalene).isFalse()
    }

    @Test
    fun `not scalene if two sides are equal`() {
        assertThat(Triangle(4, 4, 3).isScalene).isFalse()
    }

    @Test
    fun `sides violate triangle inequality so not scalene`() {
        assertThatThrownBy { Triangle(7, 3, 2) }.isInstanceOf(type(IllegalArgumentException::class))
    }

    @Test
    fun `scalene sides may be floating point`() {
        assertThat(Triangle(0.5, 0.4, 0.6).isScalene).isTrue()
    }

    private fun type(kClass: KClass<IllegalArgumentException>) = kClass.javaObjectType

}

