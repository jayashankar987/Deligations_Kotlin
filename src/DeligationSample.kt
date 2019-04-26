import kotlin.math.ceil

interface Car {
    fun maker(): String
    fun price(): Int
}

interface Plane {
    fun builder(): String
    fun price(): Int
}

class Boeing : Plane {
    override fun builder(): String {
        return "Boeing"
    }

    override fun price(): Int {
        println("${builder()} price 350000")
        return 350000
    }
}


class Audi : Car {
    override fun maker(): String {
        return "Audi"
    }

    override fun price(): Int {
        println("${maker()} price 4000")
        return 4000
    }
}

class Hyundai : Car {
    override fun maker(): String {
        return "Hyundai"
    }

    override fun price(): Int {
        println("${maker()} price 2000")
        return 2000
    }
}

class Seller(private val car: Car, private val plane: Plane) : Car by car, Plane by plane {

    override fun price(): Int {
        //Both interfaces have same method price which we need to override in this class
        println("My Price: ${car.maker()} ${myPrice(car.price())}")
        println("My Price: ${plane.builder()} ${myPrice(plane.price())}")
        return -1
    }

    fun myPrice(price: Int): Int {
        return price.plus(ceil(price * 0.2).toInt())
    }

}

fun main(args: Array<String>) {

    val seller = Seller(Audi(), Boeing())
    seller.price()
}




