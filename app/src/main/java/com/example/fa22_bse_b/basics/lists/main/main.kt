package com.example.fa22_bse_b.basics.lists.main

import com.example.fa22_bse_b.basics.lists.model.Movie


fun main() {
    println("Here we are -- Lists")

    val movie: Movie = Movie(title = "Iron Man", releaseDate = "712", price = 10)

    // Lists --> Array
//    Movie movieList[20] = {}

    val movieList: MutableList<Movie> = mutableListOf(
        Movie(title = "Iron Man", releaseDate = "712", price = 10),
        Movie(title = "Doctor Strange", releaseDate = "123", price = 20),
        Movie(title = "Barbie", releaseDate = "456", price = 10000),
        Movie(title = "Pushpa", releaseDate = "789", price = 200)
    )

    movieList.add(Movie("abc","122",-20))

    val m = movieList.getOrNull(5)

    showMovie(m)




}

// ? null safety operator
fun showMovie(movie: Movie?) {
    print("Movie ->  Title: ${movie?.title?:""}, ReleaseDate: ${movie?.releaseDate?:""}, Price: ${movie?.price?:0}")
}
