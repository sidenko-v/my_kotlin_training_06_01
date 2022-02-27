import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    val photoAtt = Photo(1,2,3,4,"какой-то текст",11011101)
    val postedPhotoAtt = PostedPhoto(1,2,"text","text2")
    val videAtt = Video(1,2,"Тайтл","Дескрипшн",12121111)
    val audioAtt = Audio(1,2,"Какой-то артист","Тайтл",5,12312131)
    val docAtt = Doc(1,2,"Тайтл","урл",1231233321)
    val attachment: Array<Attachment> = arrayOf(photoAtt,postedPhotoAtt,videAtt,audioAtt,docAtt)


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
            null,
            7,
            5,
            5,
            "test",
            attachment,
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
        val id = WallService.posts.last().id
        val post: Post = Post(
            id,
            2,
            3,
            3,
            1,
            "text",
            3,
            4,
            true,
            6,
            null,
            7,
            5,
            5,
            "test",
            attachment,
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
            1005000000,
            2,
            3,
            3,
            1,
            "text",
            3,
            4,
            true,
            6,
            null,
            7,
            5,
            5,
            "test",
            attachment,
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