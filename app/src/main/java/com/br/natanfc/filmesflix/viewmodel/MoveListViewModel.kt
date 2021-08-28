package com.br.natanfc.filmesflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.model.Movie

class MoveListViewModel : ViewModel() {

    private val listOfMovies = arrayListOf(
        Movie(
            id = 0,
            titulo = "Titanic",
            descricao = null,
            imagem = null,
            dataLancamento = null
        ),
        Movie(
            id = 1,
            titulo = "Central do Brazil",
            descricao = null,
            imagem = null,
            dataLancamento = null
        )
    )

    private var _movieList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
        get() = _movieList


    fun init(){
        getAllMovies()
    }


    private fun getAllMovies() {
        _movieList.value = listOfMovies
    }

}