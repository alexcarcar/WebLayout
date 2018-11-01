// https://www.tutorialspoint.com/kotlin/kotlin_interface.htm

interface FirstInterface {
	var myVar:String // abstract property
	fun absMethod()  // abstract method
	fun sayHello() = "Hello there\n" // method with default implementation
}

class FirstImp:FirstInterface {
	override var myVar = "first"
	override fun absMethod () {
		println("first absMethod")
	}
}

// ==========================================================

interface ExampleInterface {
	var myVar:Int // abstract property
	fun absMethod():String // abstract method

	fun hello() {
		println("Hello from ExampleInterface")
	}
}
class InterfaceImp:ExampleInterface {
	override var myVar:Int =25
	override fun absMethod() = "Happy Learning"
}

fun main(args:Array<String>) {
	val obj = InterfaceImp();
	println("${obj.myVar}")
	obj.hello();
	println(obj.absMethod())

	val firstObj = FirstImp();
	println("${firstObj.myVar}")
	firstObj.sayHello();
	firstObj.absMethod();

	// 25
	// Hello from ExampleInterface
	// Happy Learning
	// first
	// first absMethod

}