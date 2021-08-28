package com.br.natanfc.filmesflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.br.natanfc.filmesflix.api.MovieRestApiTask
import com.br.natanfc.filmesflix.model.Movie
import com.br.natanfc.filmesflix.repository.MovieRepository

class MoveListViewModel : ViewModel() {

    private  val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)

    companion object{
        const val TAG = "MovieRepository"

    }

    private var _movieList = MutableLiveData<List<Movie>>()
    val moviesList : LiveData<List<Movie>>
        get() = _movieList


    fun init(){
        getAllMovies()
    }


    private fun getAllMovies() {
        Thread{
            try {
                _movieList.postValue(movieRepository.getAllMovies())
            }catch (exception:Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }

}