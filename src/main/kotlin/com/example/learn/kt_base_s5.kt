package com.example.learn

import java.io.File

open class Person(private val name: String) {
    fun showName() = "person name is $name"
    open fun myPrintln() = println(showName())
    fun mp() = println("I'm father")
}

class Student(private val subName: String) : Person(subName) {
    override fun myPrintln() = println("sub class name is $subName")
    fun ms() = println("I'm child")
}

object KtBase87 {
    init {
        println("init 87")
    }

    fun show() = println("I'm show function!")
}

open class KtBase88 {
    open fun add(info: String) = println("KtBase88 add:$info")
    open fun del(info: String) = println("KtBase88 del:$info")
}

class KtBase89 {
    companion object {
        val info = "LayneInfo"
        fun showInfo() = println("show:$info")
    }

}

class Body(_bodyInfo: String) {
    val bodyInfo = _bodyInfo
    fun show() = {
        Heart().run()
    }

    companion object {
        val body1 = "body11"
    }

    inner class Heart {
        val hear1 = "h1"
        fun run() = println("heart inner class:$body1, $bodyInfo")
    }

    inner class Kidney {
        fun work() = println("kidney inner class:$bodyInfo")
    }

    inner class Hand {
        inner class LeftHand {
            fun run() = println("left hand info:$bodyInfo")
        }

        inner class RightHand {
            fun run() = println("right hand info:$bodyInfo")
        }
    }
}

data class KtBase92(var name: String, var age: Int) {
    var coreInfo: String = ""

    init {
        println("main constructor is invoked!")
    }

    // secondary constructor
    constructor(name: String) : this(name, 99) {
        println("secondary constructor")
        coreInfo = "add core info"
    }

    override fun toString(): String {
        return "toString name:$name, age:$age, coreInfo:$coreInfo"
    }
}

class Student1(var name: String, var age: Int, var sex: Char) {
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = sex
}

data class Student2(var name: String, var age: Int, var sex: Char)

data class AddClass(var number1: Int, var number2: Int) {
    operator fun plus(p1: AddClass): AddClass {
        return AddClass(number1 + p1.number1, number2 + p1.number2)
    }
}

enum class Week {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}

data class LimbsInfo(var limbsInfo: String, var length:Int){
    fun show(){
        println("${limbsInfo}'s length is :$length")
    }
}

enum class Limbs(private val limbsInfo: LimbsInfo){
    LEFT_HAND(LimbsInfo("left hand", 88)),
    RIGHT_HAND(LimbsInfo("right hand", 89)),
    LEFT_FOOT(LimbsInfo("left foot", 100)),
    RIGHT_FOOT(LimbsInfo("right foot", 101));

    fun show() = "limbs are:${limbsInfo.limbsInfo}, length is:${limbsInfo.length}"

    fun updateData(limbsInfo: LimbsInfo){
        this.limbsInfo.limbsInfo = limbsInfo.limbsInfo
        this.limbsInfo.length=limbsInfo.length
        println("updated data is:${this.limbsInfo}")
    }
}

fun main() {
    val person: Person = Student("Layne good")
    person.myPrintln()
    println(person is Person)
    println(person is File)

    if (person is Student) {
        (person as Student).myPrintln()
    }

    if (person is Person) {
        println((person as Person).showName())
    }
    (person as Student)
    person.ms()
    if (person is Student) {
        person.ms()
    }

    println(KtBase87)
    println(KtBase87)
    KtBase87.show()
    println("-----------88")
    val p: KtBase88 = object : KtBase88() {
        override fun add(info: String) {
//            super.add(info)
            println("no name object add:$info")
        }

        override fun del(info: String) {
//            super.del(info)
            println("no name object del:$info")
        }
    }
    p.add("hello")
    p.del("hh")
    object : Runnable {
        override fun run() {
            println(1)
        }

    }.run()

    println(KtBase89.info)
    KtBase89.showInfo()

    println("--------92")
    val p92 = KtBase92("Layne")
    println(p92)

    println("--------93")
    val (name1, age1, sex1) = Student1("Layne", 36, 'M')
    println("common class name:$name1, age:$age1, sex:$sex1")
    val (name2, age2, sex2) = Student2("Layne", 36, 'M')
    println("common class name:$name2, age:$age2, sex:$sex2")

    println("--------94")
    println(AddClass(1, 1) + AddClass(2, 2))
    println("--------95")
    println(Week.Monday)
    println(Limbs.LEFT_FOOT.show())
    Limbs.RIGHT_HAND.updateData(LimbsInfo("right hand 2", 111))
}