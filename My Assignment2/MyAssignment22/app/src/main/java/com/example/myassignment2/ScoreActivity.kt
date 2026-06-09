package com.example.myassignment2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)


        val scoreText = findViewById<TextView>(R.id.scoreText)
        val feedbackText = findViewById<TextView>(R.id.finalFeedback)
        val reviewText = findViewById<TextView>(R.id.reviewText)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)

        val score = intent.getIntExtra("score", 0)

        scoreText.text = "Score: $score / 5"

        feedbackText.text = if (score >= 4) {
            "Master Hacker! 🔥"
        } else {
            "Keep Practising! ⚠️"
        }

        reviewBtn.setOnClickListener {
            reviewText.text = """
                Rice doesn't fix phones ❌
                Notifications off improves focus ✅
                Coffee hydrates 
                To-do lists help ✅
                Overnight charging safe 
            """.trimIndent()
        }
    }
}
