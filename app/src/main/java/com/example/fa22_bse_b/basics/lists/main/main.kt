package com.example.fa22_bse_b.basics.lists.main

import com.example.fa22_bse_b.basics.lists.model.Movie


fun main() {
    println("Here we are -- Lists")

//    val movie: Movie = Movie(title = "Iron Man", releaseDate = "712", price = 10)

    // Lists --> Array
//    Movie movieList[20] = {}

    var movieList: MutableList<Movie>? = null
    movieList = mutableListOf()

    println("first member of list = ${movieList?.getOrNull(0)}")

    movieList = mutableListOf(
        Movie(title = "Iron Man", releaseDate = "712", price = 10),
        Movie(title = "Doctor Strange", releaseDate = "123", price = 20),
        Movie(title = "Barbie", releaseDate = "456", price = 10000),
        Movie(title = "Pushpa", releaseDate = "789", price = 200)
    )
    movieList.add(Movie("abc","122",-20))




//    var index: Int = 0
//
//    while(index<movieList.size) {
//        showMovie(movieList.get(index))
//        index++
//    }


//    arrayListOf(11,22,33,44,55,66).forEach { it ->
//        println("Number is -> $it")
//    }

//    movieList.forEach { movie ->
//        showMovie(movie)
//    }


//
//    movieList.forEach { it->
//
//    }
//    val m = movieList.getOrNull(5)

//    showMovie(m)
//    showMovie(movieList.get(movieList.size-1))

//    for (i in 0..5) {
//        println(" i = $i")
//    }

//    for(i in 0..movieList.size-1) {
////        println(" i = $i")
//        showMovie(movieList.get(i))
//    }






}

// ? null safety operator
fun showMovie(movie: Movie?) {
    println("Movie ->  Title: ${movie?.title?:""}, ReleaseDate: ${movie?.releaseDate?:""}, Price: ${movie?.price?:0}")
}
