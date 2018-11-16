// https://www.tutorialspoint.com/kotlin/kotlin_functions.htm

fun MyFunction(x:String):String {
	var c:String = "Hey!! Welcome To ---"
	return (c+x)
}

fun example1() {
	println(MyFunction("Kotlin")) // Hey!! Welcome To ---Kotlin
}

// =================================================================
// Lambda Function: "declare and pass your lambda to a function"

fun example2() {
	val mylambda:(String)->Unit = {s:String->println("lambda: $s")}
	val v:String = "Kotlin"
	mylambda(v) // lambda: Kotlin
}

// =================================================================
// Inline Function: Now, we can pass a lambda to another function to
// get our output which makes the calling function an inline function

fun example3() {
	val mylambda:(String)->Unit= {s:String->println("inline: $s")}
	val v:String = "Kotlin"
	myFun(v,mylambda)
}

fun myFun(a:String, action:(String)->Unit) { // passing lambda
	print("Heyyy!!!")
	action(a) // call to lambda function
	// Heyyy!!!inline: Kotlin
}

fun main(args:Array<String>) {
	example1()
	example2()
	example3()
}
