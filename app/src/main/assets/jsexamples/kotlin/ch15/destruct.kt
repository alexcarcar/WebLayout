// https://www.tutorialspoint.com/kotlin/kotlin_destructuring_declarations.htm

// Kotlin - Destructuring Declarations
// ===============================================================
// Used to declare multiple variables at once, for example:
// val (name, age) = person

fun main(args:Array<String>) {
	val s = Student("My School", "Kotlin")
	val (name, subject) = s
	println("You are learning "+subject+" from "+name)
}

data class Student(val a:String, val b:String) {
	var name:String = a
	var subject:String = b
}