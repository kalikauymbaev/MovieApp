package com.example.list.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.list.data.api.TheMovieDBInterface
import com.example.list.data.repository.MovieDetailsNetworkDataSource
import com.example.list.data.repository.NetworkState
import com.example.list.data.vio.MovieDetails
import io.reactivex.disposables.CompositeDisposable



class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}