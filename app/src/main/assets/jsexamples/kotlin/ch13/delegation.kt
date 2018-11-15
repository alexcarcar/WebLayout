// https://www.tutorialspoint.com/kotlin/kotlin_delegation.htm

// - Demonstrates "delegation" design pattern (using the keyword "by")
// - Kotlin allows the derived class to access all implemented public
// methods of an interface through a specific object.

interface Base {
	fun printMe() // abstract method	
}

class BaseImpl(val x:Int):Base {
	override fun printMe() {
		println(x) // implementation of the method
	}
}

 // delegating the public method on object b
 class Derived(b:Base):Base by b

 fun main(args:Array<String>) {
 	val b = BaseImpl(10)
 	Derived(b).printMe() // 10
 }