// https://www.tutorialspoint.com/kotlin/kotlin_class_and_object.htm
// 
// kotlinc controlFlow.kt -include-runtime -d controlFlow.jar
// java -jar controlFlow.jar

class myClass {
	private var name:String = "kotlin"
	fun printMe() {
		println("You are using " + name)
	}
}

// ### Nested Class
class Outer {
	class Nested {
		fun foo() = "Welcome to kotlin"
	}
}

fun main(args:Array<String>) {
	val obj = myClass()
	obj.printMe() // You are using kotlin

	val demo = Outer.Nested().foo()
	println(demo) // Welcome to kotlin

}
