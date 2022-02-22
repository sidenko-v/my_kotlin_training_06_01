object WallService {

    var posts = emptyArray<Post>()
    var isUpdated: Boolean = false
    var uniqId: Int = 0

    fun add(post: Post): Post {
        posts += post
        val post = post.copy(id = createUniqId(posts))
        posts.set(posts.lastIndex, post)

        return posts.last()
    }

    fun createUniqId(posts: Array<Post>): Int {
        uniqId = (0..1_000_000_000).random()
        for (i in 0..posts.size - 1) {
            if (uniqId == posts[i].id) {
                createUniqId(posts)
                break
            }
        }
        return uniqId
    }


    fun update(post: Post): Boolean {

        val newPostId = post.id

        for (i in 0..posts.size - 1) {
            var oldPostId = posts[i].id

            if (newPostId == oldPostId) {

                posts[i] = post.copy(
                    text = post.text,
                    comments = post.comments,
                    likes = post.likes,
                    reposts = post.reposts,
                    friendsOnly = !post.friendsOnly,
                    copyright = !post.copyright,
                    views = post.views,
                    canPin = !post.canPin,
                    canDelete = !post.canDelete,
                    canEdit = !post.canEdit,
                    isPinned = !post.isPinned,
                    markedAsAds = !post.markedAsAds,
                    isFavorite = !post.isFavorite,
                    donut = post.donut,

                    )
                isUpdated = true
                break
            } else {
                isUpdated = false
            }
        }
        return isUpdated
    }
}


