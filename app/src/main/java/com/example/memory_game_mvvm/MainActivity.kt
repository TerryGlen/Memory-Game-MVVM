package com.example.memory_game_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memory_game_mvvm.ui.game.GameFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, GameFragment.newInstance())
                .commitNow()
        }
    }

}
