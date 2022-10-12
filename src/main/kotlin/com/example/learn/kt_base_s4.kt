package com.example.learn

class KtBase72(_name: String, _sex: Char, _age: Int, _info: String) {
    var name = _name

    val sex = _sex
    //        set(value) = 1

    val age = _age
        get() = if (field < 0) -1 else field

    val info = _info
        get() = "[$field]"

    fun show() {
        println(name)
        println(sex)
        println(age)
        println(info)
    }
}

class KtBase73(var name: String, val sex: Char, val age: Int, var info: String) {
    fun show() {
        println(name)
    }
}

class KtBase74(name: String) {
    constructor(name: String, sex: Char) : this(name) {
        println("two parameters secondary constructor name:$name, sex:$sex")
    }

    constructor(name: String, sex: Char, age: Int) : this(name) {
        println("three parameters secondary constructor name:$name, sex:$sex, age:$age")
    }

    constructor(name: String, sex: Char, age: Int, info: String) : this(name) {
        println("four parameters secondary constructor name:$name, sex:$sex, age:$age, info:$info")
    }
}

class KtBase76(username: String, userage: Int, usersex: Char) {
    init {
        println("main constructor is invoked! username:$username, userage:$userage, usersex:$usersex")
    }

    constructor(username: String) : this(username, 36, 'M') {
        println("second constructor is invoked!")
    }
}

class KtBase77(_name: String, val sex: Char) {
    val mName = _name

    init {
        val nameValue = _name
        println("init block code. nameValue:$nameValue")
//        println(layne)
    }

    constructor(name: String, sex: Char, age: Int) : this(name, sex) {
        println("secondary constructor, name:$name, sex:$sex, age:$age")
    }

    val layne = "aaa"
}

class KtBase78 {
    lateinit var responseResultInfo: String

    fun loadRequest() {
        responseResultInfo = "load successfully, congratulation!"
    }

    fun showResponseResult() {
        if (::responseResultInfo.isInitialized) {
            println("response result info:$responseResultInfo")
        } else {
            println("you have not init variable.")
        }
    }
}

class KtBase79 {
    val data1 = readDatabase()
    val data2 by lazy { readDatabase() }

    private fun readDatabase(): String {
        println("read...")
        return "database load is ok."
    }
}

class KtBase80 {
    val info: String

    init {
        info = "Layne"
        getInfo()
    }

    private fun getInfo() {
        println("info:${info[0]}")
    }
}

class KtBase82(_info: String) {
    val info = _info
    val len = getInfoMethod()
    fun getInfoMethod() = info
}

fun main() {
    val p = KtBase72(_name = "conglanjun", _info = "learn kt", _age = 36, _sex = 'M')
    println(p.name)
    p.name = "Layne"
    p.show()
    val k1 = KtBase73(name = "Layne1986", sex = 'M', age = 36, info = "learn xxx")
    k1.show()
    println("---------")
    val k74 = KtBase74("Layne19860125")
    KtBase74("Layne19860125", 'M')
    KtBase74("Layne19860125", 'M', 88)
    KtBase74("Layne19860125", 'M', 78, "learning kt base")
    println("----------")
    KtBase76("Layne", 35, 'M')
    KtBase76("conglanjun")
    println("----------")
    val kt78 = KtBase78()
    kt78.loadRequest()
    kt78.showResponseResult()
    println("-----------")
    val k79 = KtBase79()
    println("I'll use it!")
    println(k79.data1)
    println("I'll use it!")
    println(k79.data2)
    println("----------80")
    KtBase80()
    println("----------82")
    println("content len:${KtBase82("Layne").len.length}")
}