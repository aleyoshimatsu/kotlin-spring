package dev.alexandreyoshimatsu.kotlinspring.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
