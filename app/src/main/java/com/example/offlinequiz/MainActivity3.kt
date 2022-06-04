package com.example.offlinequiz

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.CountDownTimer
import android.renderscript.Matrix2f
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.offlinequiz.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var questionsQuiz: List<Question>
    private lateinit var currentQuestion: Question
    private var selectedOptionId = 0
    private var step = 0
    private var correctAnswersCounter = 0
    internal var gameStarted = false
    private lateinit var countDownTimer: CountDownTimer
    internal var initialCountDown: Long = 10000
    internal var countDownInterval: Long = 1000



    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val backContinents = findViewById<ImageView>(R.id.back)
        backContinents.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
            finish()
        }

        val nameOfContinent = intent.getStringExtra("continent")
        val name = intent.getStringExtra(Continents.name).toString()
        binding.questions.text = "${step+1}/5"

        when (nameOfContinent) {
            "Amerika" -> questionsQuiz = Continents.getQuestionAmerica()
            "Afrika" -> questionsQuiz = Continents.getQuestionAfrika()
            "Asia" -> questionsQuiz = Continents.getQuestionAsia()
            "Europe" -> questionsQuiz = Continents.getQusestionEurope()
        }

        setQuestion(step)
        binding.continentName.text = nameOfContinent
        binding.apply {
            btnOptionOne.setOnClickListener {
                setSelectedOption(1)
                selectedOptionId = 1
            }
            btnOptionTwo.setOnClickListener {
                setSelectedOption(2)
                selectedOptionId = 2
            }
            btnOptionThree.setOnClickListener {
                setSelectedOption(3)
                selectedOptionId = 3
            }
            btnOptionFour.setOnClickListener {
                setSelectedOption(4)
                selectedOptionId = 4
            }
            binding.nextbtn.setOnClickListener {
                if (binding.nextbtn.text == getString(R.string.submit)) {
                    if (selectedOptionId != 0) {
                        checkAnswer()
                        step++
                        if (step == questionsQuiz.size) {
                            binding.nextbtn.text = getString(R.string.finish_text)
                        }
                    } else {
                        step++

                        if (step != questionsQuiz.size) {
                            binding.questions.text = "${step + 1}/5"
                        }

                        if (step == questionsQuiz.size) {
                            binding.nextbtn.text = getString(R.string.finish_text)
                            isNotClickable(false)
                        } else {
                            setQuestion(step)
                        }
                    }
                } else if (binding.nextbtn.text == getString(R.string.finish_text)) {
                    val intent = Intent(this@MainActivity3, ResultActiv::class.java)
                    intent.putExtra("score", correctAnswersCounter)
                    intent.putExtra(Continents.name, name)
                    startActivity(intent)
                    finish()
                } else {
                    setQuestion(step)
                    binding.questions.text = "${step+1}/5"
                    binding.nextbtn.text = getString(R.string.submit)
                }
            }
        }
    }

    private fun setQuestion(index: Int) {
        currentQuestion = questionsQuiz[index]

        binding.apply {
            btnOptionOne.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionTwo.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionThree.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionFour.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))

            tvQuestion.text = currentQuestion.question
            btnOptionOne.text = currentQuestion.options[0]
            btnOptionTwo.text = currentQuestion.options[1]
            btnOptionThree.text = currentQuestion.options[2]
            btnOptionFour.text = currentQuestion.options[3]
        }
        resetGame()
        startGame()
        changeOptionsBehavior(true)
        selectedOptionId = 0
    }

    private fun setSelectedOption(selectedOptionId: Int) {
        binding.apply {
            btnOptionOne.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionTwo.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionThree.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))
            btnOptionFour.backgroundTintList =
                ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.white))

            when (selectedOptionId) {
                1 -> btnOptionOne.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.selected_color))
                2 -> btnOptionTwo.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.selected_color))
                3 -> btnOptionThree.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.selected_color))
                4 -> btnOptionFour.backgroundTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@MainActivity3,R.color.selected_color))
            }
        }
    }

    private fun checkAnswer() {
        binding.apply {
            when (selectedOptionId) {
                1 -> btnOptionOne.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.wrong_color)
                2 -> btnOptionTwo.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.wrong_color)
                3 -> btnOptionThree.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.wrong_color)
                4 -> btnOptionFour.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.wrong_color)
            }

            when (currentQuestion.correctAnswerId + 1) {
                1 -> btnOptionOne.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.correct_color)
                2 -> btnOptionTwo.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.correct_color)
                3 -> btnOptionThree.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.correct_color)
                4 -> btnOptionFour.backgroundTintList =
                    ContextCompat.getColorStateList(this@MainActivity3,R.color.correct_color)
            }

            if (selectedOptionId == currentQuestion.correctAnswerId + 1) {
                correctAnswersCounter++
            }

            changeOptionsBehavior(false)
            binding.nextbtn.text = getString(R.string.continue_text)
        }
    }

    private fun changeOptionsBehavior(enabled: Boolean) {
        binding.apply {
            btnOptionOne.isEnabled = enabled
            btnOptionTwo.isEnabled = enabled
            btnOptionThree.isEnabled = enabled
            btnOptionFour.isEnabled = enabled
        }
    }
    private fun isNotClickable(click: Boolean) {
        binding.apply {
            btnOptionOne.isClickable = click
            btnOptionTwo.isClickable = click
            btnOptionThree.isClickable = click
            btnOptionFour.isClickable = click
        }
    }
    private fun resetGame() {
        val initialTimeLeft = initialCountDown / 1000
        binding.apply {
            timer.text = initialTimeLeft.toString()

            countDownTimer = object: CountDownTimer(initialCountDown,countDownInterval) {
                override fun onTick(millisUntilFinished: Long) {
                    val timeLeft = millisUntilFinished / 1000
                    timer.text = timeLeft.toString()
                }

                override fun onFinish() {

                }
            }
        }
        gameStarted = false
    }
    private fun startGame() {
        countDownTimer.start()
        gameStarted = true
    }
}

