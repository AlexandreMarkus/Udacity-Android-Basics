package com.android.courtcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var scoreTeamA = 0
        var scoreTeamB = 0

        fun displayForTeamA() {
            team_a_count_text_view.text = scoreTeamA.toString()
        }

        fun displayForTeamB(){
            team_b_count_text_view.text = scoreTeamB.toString()
        }

        this.point3_button.setOnClickListener {
            scoreTeamA += 3
            displayForTeamA()
        }

        this.point2_button.setOnClickListener {
            scoreTeamA += 2
            displayForTeamA()
        }

        this.free_point_button.setOnClickListener {
            scoreTeamA += 1
            displayForTeamA()
        }

        this.point3_b_button.setOnClickListener {
            scoreTeamB += 3
            displayForTeamB()
        }

        this.point2_b_button.setOnClickListener {
            scoreTeamB += 2
            displayForTeamB()
        }

        this.free_point_b_button.setOnClickListener {
            scoreTeamB += 1
            displayForTeamB()
        }

        this.reset_button.setOnClickListener {
            scoreTeamA = 0
            scoreTeamB = 0
            displayForTeamA()
            displayForTeamB()
        }

    }
}