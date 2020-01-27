package com.example.memory_game_mvvm.ui.game

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.memory_game_mvvm.R
import com.example.memory_game_mvvm.databinding.GameFragmentBinding
import kotlinx.android.synthetic.main.main_activity.*

class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: GameFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.game_fragment, container, false)



        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        // TODO: Use the ViewModel

        binding.gameViewModel = viewModel
        binding.setLifecycleOwner(this)


        val adapter = CardAdapter(GameClickListener { card ->
            viewModel.onClick(card)
        })
        binding.cardList.adapter = adapter
        val manager = GridLayoutManager(activity, 4)

        binding.cardList.layoutManager = manager



        viewModel.cardList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }


}
