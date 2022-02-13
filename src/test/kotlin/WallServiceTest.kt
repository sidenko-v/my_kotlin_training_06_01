import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @org.junit.Test
    fun add_idShouldNotBeEqualToZero() {

        val post: Post = Post(
            1,
            2,
            3,
            3,
            1,
            "text",
            3,
            4,
            true,
            6,
            true,
            7,
            5,
            5,
            "test",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            5,
            5
        )

        val id = WallService.add(post).id
        val result = id != 0
        assertEquals(true, result)
    }

    @Test
    fun update_ShouldBeUpdatedWithExistingId() {
        val post: Post = Post(
            1,
            2,
            3,
            3,
            1,
            "text",
            3,
            4,
            true,
            6,
            true,
            7,
            5,
            5,
            "test",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            5,
            5
        )

        WallService.add(post)
        val result = WallService.update(post)

        assertEquals(true, result)


    }

    @Test
    fun update_ShouldNotBeUpdatedWithNoExistingId() {
        val post: Post = Post(
            100500,
            2,
            3,
            3,
            1,
            "text",
            3,
            4,
            true,
            6,
            true,
            7,
            5,
            5,
            "test",
            5,
            true,
            true,
            true,
            true,
            true,
            true,
            5,
            5
        )
        val result = WallService.update(post)
        assertEquals(false, result)
    }
}