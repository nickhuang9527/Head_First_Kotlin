fun main() {
    var a = 2
    var b = a

    println("a: (value) $a (Memory)")
    a = 5
    println(a)
    println(b)

    var a1: ArrayList<Int> = arrayListOf(1, 2, 3)
    var b1 = a1
    a1[0] = 3

    print(a1)
    print(b1)
}