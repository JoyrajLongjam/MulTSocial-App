package com.joyrajlongjam.MulTSocial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.ktx.Firebase
import com.joyrajlongjam.MulTSocial.daos.PostDao
import com.joyrajlongjam.MulTSocial.models.Post
import kotlinx.android.synthetic.main.activity_post.*

class post : AppCompatActivity(), IPostAdapter {
    private lateinit var postDao: PostDao
    private lateinit var adapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        fab.setOnClickListener{
            val intent = Intent(this, CreatePostActivity::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        postDao = PostDao()
        val postsCollections = postDao.postCollections
        val query = postsCollections.orderBy("createdAt", Query.Direction.DESCENDING)
      val recyclerViewOptions = FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post::class.java).build()

       adapter = PostAdapter(recyclerViewOptions, this)

       recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


     p.setOnClickListener(){
        Firebase.auth.signOut();
         startActivity(Intent(this,SignInActivity::class.java))
         finish()
     }

    }

    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onLikeClicked(postId: String) {
        postDao.updateLikes(postId)
    }


}
