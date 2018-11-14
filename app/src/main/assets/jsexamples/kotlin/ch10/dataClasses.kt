// https://www.tutorialspoint.com/kotlin/kotlin_data_classes.htm

fun main(args:Array<String>) {
	val book:Book = Book("Kotlin", "Google", 5)
	println(book.name) // Kotlin
	println(book.publisher) // Google
	println(book.reviewScore) // 5
	book.reviewScore = 7
	println(book.toString()) // Book(name=Kotlin, publisher=Google, reviewScore=7)
	println(book.hashCode()) // -1703788113
}

// An example of a data class
// uses "var" for members that can be reassigned
// uses "val" for constants

data class Book (
	val name:String,
	val publisher:String,
	var reviewScore:Int
)