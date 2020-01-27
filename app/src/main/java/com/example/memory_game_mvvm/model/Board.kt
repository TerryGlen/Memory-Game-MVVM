package com.example.memory_game_mvvm.model

import android.graphics.Color
import java.util.*

    val cards = mutableListOf<Card>()
    private val palette = Stack<Int>()

    fun getCardList(numCards: Int) : List<Card>{
        for(i in 1..numCards){
            cards.add(Card(i, Color.WHITE, false, false))
        }
        shuffle()
        return cards
    }


    fun shuffle() {

        randomizeColors()
        cards.forEach {
            it.color = palette.pop()
        }

    }
    private fun randomizeColors() {
        val colorList = Stack<Int>()

        colorList.addAll(
            listOf(

                Color.rgb(212, 255, 234), //light blue
                Color.rgb(238, 203, 255), //purple
                Color.rgb(255, 165, 0) ,//orange
                Color.rgb(64, 224, 208), //teal
                Color.rgb(84,139,84), //dark green
                Color.rgb(179,255,169), //Green
                Color.rgb(255,169,179), //Pink
                Color.rgb(169,179,255), //blue
                Color.rgb(253,255,152), //Yellow
                Color.rgb(223,193,137) //Brown
            )

        )

        //Shuffle the colorList so the same colors don't get added every time
        colorList.shuffle()


        //Adds 2 colors to our Palette stack form our colorList
        //This esential
        for (i in 0 until cards.size step 2) {
            val currentColor = colorList.pop()
            palette.add(currentColor)
            palette.add(currentColor)
        }

        //Shuffle our palette so our colors are assigned randomly.
        palette.shuffle()
    }
