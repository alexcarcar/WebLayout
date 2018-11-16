// https://www.tutorialspoint.com/kotlin/kotlin_delegation.htm

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

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

fun example1() {
 	val b = BaseImpl(10)
	Derived(b).printMe() // 10 	
}

//=============================================================
// delegation of properties using standards methods in Kotlin library
// - delegation means passing responsibility to another class or method
// - when a property is already declared, when we should reuse
//
// Lazy() is a lambda function which takes a property and returns
// an instance of Lazy<T>, where <T> is the type of the property

val myVar:String by lazy {"Hello"}
fun example2() {
	println(myVar + " my dear friend") // Hello my dear friend
}

//=============================================================
// Delegation.Obserable() takes two arguments ti initialize the object
// and return the same to the called function.

class User {
	// The expression after the "by" keyword is delegated
	var name:String by Delegates.observable("Welcome") {
		_, old, new ->
		println("$old -> $new")
	}
}

fun example3() {
	val user = User()
	user.name = "first" // Welcome -> first
	user.name = "second" // first -> second
}

//=============================================================
// In the following example, the get() and set() methods of the
// variable p are delegated to to its getValue() and setValue() methods
class Example {
	var p:String by Delegate()
}

class Delegate {
	operator fun getValue(thisRef:Any?, property:KProperty<*>):String {
		return "$thisRef, thank you for delegating '${property.name}' to me!"
	}
	operator fun setValue(thisRef:Any?, property:KProperty<*>, value:String) {
		println("$value has been assigned to '${property.name} in $thisRef.'");
	}
}

fun example4() {
	var v = Example()
	v.p = "test" // test has been assigned to 'p in Example@7229724f.'
	println(v.p) // Example@7229724f, thank you for delegating 'p' to me!
}

fun main(args:Array<String>) {
 	example1()
 	example2()
 	example3()
 	example4()
}