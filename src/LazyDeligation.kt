class Info(map: Map<String, Any?>) {
    val user: User by map
}


class User {
    val userName: String by lazy {
        println("set username")
        "Jay"
    }
    val userAge: Int by lazy {
        println("set age")
        30
    }
}

fun main(args: Array<String>) {
    val data = Info(mapOf("key" to "employee", "user" to User()))
    println("${data.user.userName}")
    println("${data.user.userAge}")
}