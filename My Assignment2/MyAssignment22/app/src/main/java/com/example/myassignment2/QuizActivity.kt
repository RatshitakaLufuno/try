package com.example.myassignment2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private lateinit var questionText: TextView
    private lateinit var feedbackText: TextView
    private var index = 0
    private var score = 0

    private val questions = arrayListOf(
        Question("Putting your phone in rice fixes water damage", false, "Rice does not fully fix water damage."),
        Question("Turning off notifications improves productivity", true, "It reduces distractions."),
        Question("Drinking coffee dehydrates you", false, "Coffee can still hydrate."),
        Question("Making a to-do list improves focus", true, "Helps organise tasks."),
        Question("Charging phone overnight damages battery", false, "Modern phones stop overcharging.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackBtn = findViewById<Button>(R.id.hackBtn)
        val mythBtn = findViewById<Button>(R.id.mythBtn)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        loadQuestion()

        hackBtn.setOnClickListener { checkAnswer(true) }
        mythBtn.setOnClickListener { checkAnswer(false) }

        nextBtn.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
                feedbackText.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun loadQuestion() {
        questionText.text = questions[index].statement
        Log.d("QUIZ", questions[index].statement)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == questions[index].isHack) {
            score++
            feedbackText.text = "Correct! " + questions[index].explanation
        } else {
            feedbackText.text = "Wrong! " + questions[index].explanation
        }
    }
}






