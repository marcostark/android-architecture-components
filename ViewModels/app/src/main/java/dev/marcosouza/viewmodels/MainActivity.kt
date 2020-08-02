package dev.marcosouza.viewmodels

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)
    }

    fun onePointForTeamA(v: View?) {
        viewModel.scoreTeamA += 1
        displayForTeamA(viewModel.scoreTeamA)
    }

    fun twoPointsForTeamA(v: View?) {
        viewModel.scoreTeamA += 2
        displayForTeamA(viewModel.scoreTeamA)
    }

    fun threePointsForTeamA(view: View?) {
        viewModel.scoreTeamA += 3
        displayForTeamA(viewModel.scoreTeamA)
    }

    fun onePointForTeamB(v: View?) {
        viewModel.scoreTeamB += 1
        displayForTeamB(viewModel.scoreTeamB)
    }

    fun twoPointsForTeamB(v: View?) {
        viewModel.scoreTeamB += 2
        displayForTeamB(viewModel.scoreTeamB)
    }

    fun threePointsForTeamB(v: View?) {
        viewModel.scoreTeamB += 3
        displayForTeamB(viewModel.scoreTeamB)
    }

    fun resetScore(v: View?) {
        viewModel.scoreTeamA = 0
        viewModel.scoreTeamB = 0
        displayForTeamA(viewModel.scoreTeamA)
        displayForTeamB(viewModel.scoreTeamB)
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
