package dev.marcosouza.viewmodels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var scoreTeamA = 0
    var scoreTeamB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onePointForTeamA(v: View?) {
        scoreTeamA += 1
        displayForTeamA(scoreTeamA)
    }

    fun twoPointsForTeamA(v: View?) {
        scoreTeamA += 2
        displayForTeamA(scoreTeamA)
    }

    fun threePointsForTeamA(view: View?) {
        scoreTeamA += 3
        displayForTeamA(scoreTeamA)
    }

    fun onePointForTeamB(v: View?) {
        scoreTeamB += 1
        displayForTeamB(scoreTeamB)
    }

    fun twoPointsForTeamB(v: View?) {
        scoreTeamB += 2
        displayForTeamB(scoreTeamB)
    }

    fun threePointsForTeamB(v: View?) {
        scoreTeamB += 3
        displayForTeamB(scoreTeamB)
    }

    fun resetScore(v: View?) {
        scoreTeamA = 0
        scoreTeamB = 0
        displayForTeamA(scoreTeamA)
        displayForTeamB(scoreTeamB)
    }

    private fun displayForTeamA(score: Int) {
        val scoreView = findViewById<TextView>(R.id.team_a_score)
        scoreView.text = score.toString()
    }

    private fun displayForTeamB(score: Int) {
        val scoreView = findViewById<TextView>(R.id.team_b_score)
        scoreView.text = score.toString()
    }
}
