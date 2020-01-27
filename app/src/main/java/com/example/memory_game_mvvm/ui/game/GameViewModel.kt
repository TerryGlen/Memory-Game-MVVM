package com.example.memory_game_mvvm.ui.game

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memory_game_mvvm.model.Card
import com.example.memory_game_mvvm.model.getCardList

class GameViewModel : ViewModel() {
//    private var _currentBoard  = MutableLiveData <Board>()
    private val _cardList = MutableLiveData<List<Card>>()
    val cardList : LiveData<List<Card>>
        get()= _cardList


    var _testText = MutableLiveData<String>()
    val testText : LiveData<String>
            get() = _testText


//    val currentBoard : LiveData<Board>
//        get() = _currentBoard

    init {
        _cardList.value = getCardList(6)


    }

    fun onClick(card: Card){

            var index = _cardList.value?.indexOf(card)
            val listResult = mutableListOf<Card>()
            listResult.addAll(_cardList.value as List)
            listResult[index!!].color = 10000004
            _cardList.setValue(listResult)
            _testText.value = index.toString()




    }

}
