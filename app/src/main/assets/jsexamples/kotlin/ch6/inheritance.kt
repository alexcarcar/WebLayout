import java.util.Arrays

open class ABC {
	fun think() {
		print("Hey! I am thinking")
	}
}

class BCD:ABC(){}

fun main(args:Array<String>) {
	var a = BCD()
	a.think() // Hey! I am thinking
}