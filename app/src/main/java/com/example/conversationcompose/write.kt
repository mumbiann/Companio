// WriteBlogActivity.kt
package com.example.conversationcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversationcompose.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the book image resource (replace with your actual resource ID)
        binding.bookImageView.setImageResource(R.drawable.app)

        // TODO: Implement the logic for sharing the blog when the button is clicked
        binding.shareButton.setOnClickListener {
            // Handle share button click
        }
    }
}
