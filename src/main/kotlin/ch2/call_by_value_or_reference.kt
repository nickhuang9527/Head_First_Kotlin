package ch2

fun main() {
    // Primitive Type
    var a: Int = 2
    var b: Int = a
    println("[Before]")
    println("a: (value) $a (HashMemory) ${System.identityHashCode(a)}")
    println("b: (value) $b (HashMemory) ${System.identityHashCode(b)}")

    /*
    在這邊print出來的a, b address會是一樣的, 所以應該是同時參考到5這個存在heap的object的address
    判斷值不是存在stack, 存在stack印出來的 address 應該會不一樣
     */

    a = 5
    println("[After]")
    println("a: (value) $a (HashMemory) ${System.identityHashCode(a)}")
    println("b: (value) $b (HashMemory) ${System.identityHashCode(b)}")

    /*
    實際上它是看似像一般其他語言直接存在stack的感覺, 但實際是在heap new了一個Int為2的記憶體並將address給stack的a
    所以不太像一般語言直接把stack中的a值換成2
     */

    /*
    在Kotlin裡點進基本型態(Int, Bool, String...), 會發現Kotlin基本型態都是class
    e.g - public class Int private constructor() : Number(), Comparable<Int>)
    也就是說Kotlin的基本型態, class, enum..., 都屬於 reference type, 都存在heap中

    https://stackoverflow.com/questions/44515031/is-kotlin-pass-by-value-or-pass-by-reference
    stackoverflow 的文章說 It uses the same principles like Java. It is always pass-by-value
    應該是指傳object時是copy一份記憶體位置, 有點類似call by address實際上也是call by value, 只是pass的是address
    與C++的call by reference不一樣.
     */


    // Class Type
    var nick = Person("Nick")
    var nick2 = nick
    println("[Before]")
    println("nick: (value) $nick (HashMemory) ${System.identityHashCode(nick)}")
    println("nick2: (value) $nick2 (HashMemory) ${System.identityHashCode(nick2)}")

    nick2.name = "Nick2"
    println("[After]")
    println("nick: (value) $nick (HashMemory) ${System.identityHashCode(nick)}")
    println("nick2: (value) $nick2 (HashMemory) ${System.identityHashCode(nick2)}")
}

class Person {
    var name: String

    constructor(name: String) {
        this.name = name
    }
}