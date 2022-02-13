object WallService {

    var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        posts += post
        val uniqId = posts.last().id + 1
        val post = post.copy(id = uniqId)
        posts.set(posts.lastIndex, post)
        return posts.last()
    }

    fun update(post: Post): Boolean {

        val post = posts.getOrNull(post.id - 1)

        if (post != null) {
            posts[post.id - 1] = post.copy(
                text = post.text + 1,
                comments = post.comments + 1,
                likes = post.likes + 1,
                reposts = post.reposts + 1,
                friendsOnly = !post.friendsOnly,
                copyright = !post.copyright,
                views = post.views + 1,
                canPin = !post.canPin,
                canDelete = !post.canDelete,
                canEdit = !post.canEdit,
                isPinned = !post.isPinned,
                markedAsAds = !post.markedAsAds,
                isFavorite = !post.isFavorite,
                donut = post.donut + 1,
            )
            return true
        } else return false

    }
}

