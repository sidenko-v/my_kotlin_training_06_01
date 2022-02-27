object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        val post = post.copy(id = createUniqId())
        posts.set(posts.lastIndex, post)

        return posts.last()
    }

    fun createUniqId(): Int {

        var uniqId: Int

        do {
            uniqId = (0..1_000_000_000).random()
        } while (posts.any { it.id == uniqId })
        return uniqId
    }


    fun update(newPost: Post): Boolean {
        var isUpdated = false
        val newPostId = newPost.id

        for (i in posts.indices) {
            var oldPostId = posts[i].id

            if (newPostId == oldPostId) {

                posts[i] = posts[i].copy(
                    text = newPost.text,
                    comments = newPost.comments,
                    likes = newPost.likes,
                    reposts = newPost.reposts,
                    friendsOnly = newPost.friendsOnly,
                    copyright = newPost.copyright,
                    views = newPost.views,
                    canPin = newPost.canPin,
                    canDelete = newPost.canDelete,
                    canEdit = newPost.canEdit,
                    isPinned = newPost.isPinned,
                    markedAsAds = newPost.markedAsAds,
                    isFavorite = newPost.isFavorite,
                    donut = newPost.donut,

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


