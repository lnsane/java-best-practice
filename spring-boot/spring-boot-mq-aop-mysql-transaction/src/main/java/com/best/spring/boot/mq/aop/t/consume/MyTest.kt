package com.best.spring.boot.mq.aop.t.consume

class MyTest {
    data class User(val name: String, val age: Int)

    fun getUserData() {
        val jack = User(name = "Jack", age = 1)
        val olderJack = jack.copy(age = 2)
        println(jack)
        println(olderJack)
    }
}