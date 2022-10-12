package com.example.learn

open class Person(private val name:String){
    private fun showName() = "person name is $name"
    open fun myPrintln() = println(showName())
}

class Student(private val subName: String) : Person(subName) {
    override fun myPrintln() = println("sub class name is $subName")
}

fun main() {
    val person:Person = Student("Layne good")
    person.myPrintln()
}