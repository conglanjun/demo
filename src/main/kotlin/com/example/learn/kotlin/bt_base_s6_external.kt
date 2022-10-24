package com.example.learn

fun <E> Iterable<E>.randomItemValue() = this.shuffled().first()

fun <T> Iterable<T>.randomItemValuePrintln() = println(this.shuffled().first())