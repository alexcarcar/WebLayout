// https://www.tutorialspoint.com/kotlin/kotlin_inheritance.htm

import java.util.Arrays

open class ABC {
	open fun think() {
		print("Hey! I am thinking")
	}
}

class BCD:ABC() {
	override fun think() {
		print("I am from child")
	}
}

fun main(args:Array<String>) {
	var a = BCD()
	a.think() // I am from child
}