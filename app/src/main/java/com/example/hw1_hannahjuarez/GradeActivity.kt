package com.example.hw1_hannahjuarez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class GradeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        findViewById<Button>(R.id.show_grade_button).setOnClickListener {
            findViewById<TextView>(R.id.grade_output).text = "Grade: " + calcGrade(
                findViewById<EditText>(R.id.grade_input).text.toString().toInt()
            )
        }
        findViewById<Button>(R.id.exit_grade_activity_button).setOnClickListener {
            this.finish()
        }
    }

    private fun calcGrade(grade: Int): String {
        if (grade < 60)
            return "F"
        if (grade < 63)
            return "D-"
        if (grade < 67)
            return "D"
        if (grade < 70)
            return "D+"
        if (grade < 73)
            return "C-"
        if (grade < 77)
            return "C"
        if (grade < 80)
            return "C+"
        if (grade < 83)
            return "B-"
        if (grade < 87)
            return "B"
        if (grade < 90)
            return "B+"
        if (grade < 93)
            return "A-"
        return "A"
    }
}