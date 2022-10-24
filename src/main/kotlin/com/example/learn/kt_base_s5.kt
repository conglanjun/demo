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
    val objectArray: Array<out I> = objects
    operator fun get(index: Int): I? = objectArray[index].takeIf { isR }
}

data class ObjectClass1(val name: String, val age: Int, val study: String)
data class ObjectClass2(val name: String, val age: Int, val study: String)
data class ObjectClass3(val name: String, val age: Int, val study: String)

class KtBase112 {
    inline fun <reified T> randomOrDefault(defaultLambdaAction: () -> T): T? {
        val objList: List<Any> = listOf(
            ObjectClass1("lisi", 22, "learn c"),
            ObjectClass2("wangwu", 23, "learn c++"),
            ObjectClass3("zhaoliu", 19, "learnC#")
        )

        val randomObject: Any = objList.shuffled().first()
        return (randomObject.takeIf { it is T } ?: defaultLambdaAction()) as T
    }
}

class KtBase113(val name: String, val age: Int, val sex: Char)

fun KtBase113.show() {
    println("I'm show function, name:$name, age:$age, sex:$sex")
}

fun String.addExtAction(number: Int) = this + "@".repeat(number)

fun <T> T.showContentInfo() =
    println("${if (this is String) "your string length is:$length" else "your string content is:$this"}")

fun <I> I.showTypesAction() =
    when (this) {
        is String -> "it's String"
        is Int -> "It's int"
        is Char -> "It's Char"
        is Float -> "It's Float"
        is Boolean -> "It's boolean"
        is Unit -> "It's Unit"
        else -> "Unknown type"
    }

fun commonFun() {}
fun commonFun1(): String = ""
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

    println("--------------")
    val listOf = listOf<Int>(123, 4355, 66)
    listOf.forEach {
        println(it)
    }

    println("----------112")
    val finalResult = KtBase112().randomOrDefault<ObjectClass1> {
        println("random product obj and input is different!")
        ObjectClass1("obj111", 23, "learn c")
    }
    println("client result:$finalResult")

    println("Layne".addExtAction(8))

    123.showContentInfo()
    "Layne".showContentInfo()
    commonFun().showContentInfo()

    println(234.showTypesAction())
    println('C'.showTypesAction())
    println(commonFun().showTypesAction())
    println(commonFun1().showTypesAction())
}