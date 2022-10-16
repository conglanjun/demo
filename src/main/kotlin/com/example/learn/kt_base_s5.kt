package com.example.learn

open class Person(private val name: String) {
    private fun showName() = "person name is $name"
    open fun myPrintln() = println(showName())
}

class Student(private val subName: String) : Person(subName) {
    override fun myPrintln() = println("sub class name is $subName")
}

open class MyAnyClass(name: String)
open class PersonClass(name: String) : MyAnyClass(name)
class StudentClass(name: String) : PersonClass(name)
class TeacherClass(name: String) : PersonClass(name)
class DogClass(name: String)

class KtBase106<T : PersonClass>(val inputTypeValue: T, private val isR: Boolean = true) {

    fun getObj(): T? = inputTypeValue.takeIf { isR }

}

class KtBase107<T>(vararg objects: T, var isMap: Boolean) {
    val objectArray: Array<out T> = objects
    fun showObj(): Array<out T>? = objectArray.takeIf { isMap }
    fun showObj(index: Int): T? = objectArray[index].takeIf { isMap } ?: null
    fun <O> mapObj(index: Int, mapAction: (T?) -> O): O? = mapAction(objectArray[index].takeIf { isMap })
}

fun <I> inputObj(item: I) {
    println((item as String?)?.length ?: "is null!!!")
}

class KtBase108<I>(vararg objects: I, val isR: Boolean = true) {
    val objectArray:Array<out I> = objects
    operator fun get(index:Int):I? = objectArray[index].takeIf { isR }
}

fun main() {
    val person: Person = Student("Layne good")
    person.myPrintln()
    println("----------106")
    val any = MyAnyClass("Layne1")
    val per = PersonClass("Layne1")
    val stu = StudentClass("Layne1")
    val tea = TeacherClass("Layne1")
    val dog = DogClass("xiaoming")

//    val r1 = KtBase106(any as PersonClass).getObj()
//    println(r1)
    val r2 = KtBase106(per).getObj()
    println(r2)
    val r3 = KtBase106(stu).getObj()
    println(r3)
    val r4 = KtBase106(tea).getObj()
    println(r4)
//    val r5 = KtBase106(dog).getObj()
//    println(r5)

    val p: KtBase107<Any?> = KtBase107("Layne", false, 345, 345.5f, 345.56, null, 'C', isMap = true)
    println(p)
    println(p.showObj(0))
    println(p.showObj(1))
    println(p.showObj(2))
    println(p.showObj(3))
    println(p.showObj(4))
    println(p.showObj(5))
    println(p.showObj(6))
//    println(p.showObj(7))
    var r11: Int? = p.mapObj(0) {
        it.toString().length
    }
    var r12: String? = p.mapObj(2) {
        "result is thrid item:${it}"
    }
    println(r11)
    println(r12)
    inputObj("Layne")
    inputObj("KKK")
    inputObj(null)

    val p1: KtBase108<String?> = KtBase108("zhangsan", "lisi", "wangwu", null)
    println(p1[0])
    println(p1[1])
}