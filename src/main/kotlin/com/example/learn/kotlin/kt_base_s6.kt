package com.example.learn

import java.io.File
import com.example.learn.randomItemValuePrintln as pl

private inline fun <I, O> I.mLet(lambda: (I) -> O) = lambda(this)
fun String?.outputStringValueFun(defaultValue: String) = println(this ?: defaultValue)

private infix fun <C1, C2> C1.gogogo(c2: C2) {
    println("in fix first param:$this")
    println("in fix second param:$c2")
}

private inline fun <INPUT> INPUT.mApply(lambda: INPUT.() -> Unit): INPUT {
    lambda(this)
    return this
}

class Context {
    val info = "I'm Layne"
    val name = "LLL"

    fun toast(str: String) = println("toast fun str:$str")
}

inline fun Context.apply5(lambda: Context.(String) -> Unit): Context {
    lambda(info)
    return this
}

class RxJavaCoreClassObject<T>(var valueItem: T) {
    init {
        println("---------init begin")
        println(this)
        println(valueItem)
        println("---------init over")
    }
}

inline fun <OUTPUT> create(action: () -> OUTPUT) = RxJavaCoreClassObject(action())

inline fun <I> RxJavaCoreClassObject<I>.observer(action: I.() -> Unit) {
    println("map, observer:$this")
    action(valueItem)
}

inline fun <I, O> RxJavaCoreClassObject<I>.map(mapAction: I.() -> O): RxJavaCoreClassObject<O> {
    println("map, this:$this")
    val r:RxJavaCoreClassObject<O> = RxJavaCoreClassObject(mapAction(valueItem))
    return r
}

fun main() {
    val r: String = "Layne".mLet {
        true
        "ok"
    }
    val infoValue: String? = null
    infoValue.outputStringValueFun("default")
    val name1 = "Layne"
    name1.outputStringValueFun("defualt")
    println("--------119")
    println(mapOf("one" to 1))
    123 gogogo 'M'

    val list1 = listOf<String>("liyb", "lilianjie", "lixiaol")
    val set1 = setOf<Double>(234.5, 456.54, 343.5)
    println()
//    list1.randomItemValuePrintln()
//    set1.randomItemValuePrintln()
    list1.pl()
    set1.pl()
    val r1: File = File("/Users/conglanjun/.zshrc").mApply {
        setReadable(true)
        println("111 ${readLines()}")
    }

    val context = Context().apply5 {
        toast("success")
        toast(it)
        toast(name)
    }.apply5 {
        println("second $name")
    }
    println(context)
    println("------124")
    val list2 = listOf<String>("lisi", "zhangsan", "wangwu")
    val list3: List<Int> = list2.map {
        88
    }
    println(list2)
    println(list3)
    println("------125")
    val list4 = listOf("lisi", "zhangsan", "wangwu")
    val list5 = list4.map {
        "your name is $it"
    }.map {
        "$it, your length is:${it.length}"
    }.flatMap {
        listOf("$it learn C", "$it learn C++", "$it learn java")
    }
    println(list5)

    println("-------126")
    val namesLists = listOf(
        listOf("zhangsan", "lisi", "wangwu"),
        listOf("zhangsan1", "lisi1", "wangwu1"),
        listOf("zhangsan2", "lisi2", "wangwu2"),
    )
    val nl1: List<Unit> = namesLists.map {
        println(it)
    }

    println()
    println()
    namesLists.flatMap { it ->
        it.filter {
            it.contains("l")
        }
    }.map {
        println("$it   ")
    }

    println("-----127")
    val names7 = listOf("zhangsan", "lisi", "wangwu", "haha")
    val ages7 = listOf(20, 12, 22)
    val zip: List<Pair<String, Int>> = names7.zip(ages7)
    println(zip)
    println(zip.toMap())

    zip.forEach {
        println("name is:${it.first}, age is:${it.second}")
    }

    println("-------136")
    create {
        "Layne"
        true
        123
//        "AAAAA"
    }.map {
        "your value is $this"
    }.map {
        "[$this]"
    }.map {
        "@@$this@@"
    }.observer{
        println(this)
    }
}