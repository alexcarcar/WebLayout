// https://www.tutorialspoint.com/kotlin/kotlin_basic_types.htm
// 
// kotlinc basicTypes.kt -include-runtime -d basicTypes.jar
// java -jar basicTypes.jar

fun main(args: Array<String>) {

	// Numbers
	val a: Int = 1000
	val d: Double = 100.00
	val f: Float = 100.00f
	val l: Long = 100000004
	val s: Short = 10
	val b: Byte = 1

	println("Your Int Value is "+a)
	println("Your Double Value is "+d)
	println("Your Float Value is "+f)
	println("Your Long Value is "+l)
	println("Your Short Value is "+s)
	println("Your Byte Value is "+b)

	// Your Int Value is 1000
	// Your Double Value is 100.0
	// Your Float Value is 100.0
	// Your Long Value is 100000004
	// Your Short Value is 10
	// Your Byte Value is 1

	// Characters
	val letter: Char 	// defining a variable
	letter = 'A'
	println("$letter")
	// A

	// Boolean
	var boo: Boolean
	boo = true
	println("Your boolean is $boo")
	// Your boolean is true
	
	// Strings
	var rawString : String = "I am a raw string!"
	var escapedString : String = "I am an escaped string!\n"
	println("Hello!" + escapedString)
	println("Hey!!"+rawString)
	// Hello!I am an escaped string!
	//
	// Hey!!I am a raw string!
	
	// Arrays
	val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5)
	println(numbers[2])
	// 3
	
	// Collections
	val mutableList: MutableList<Int> = mutableListOf(1, 2, 3) // mutable list
	val readOnlyView: List<Int> = mutableList // immutable list
	println("my mutable list--" + mutableList)
	mutableList.add(4)
	println("my mutable list--" + mutableList)
	println(readOnlyView)
	// my mutable list--[1, 2, 3]
	// my mutable list--[1, 2, 3, 4]
	// [1, 2, 3, 4]
	// readOnlyView.clear() // = does not compile
	 
	val items = listOf(1, 2, 3, 4)
	println(items.first() + items.last()) // 5
	println(items.filter{it%2==0}) // [2, 4]
	val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
	println(readWriteMap["foo"]) // 1
	val strings = hashSetOf("a", "b", "c", "c")
	println(strings) // [a, b, c]

	// Ranges
	val i: Int = 2
	for (j in 1..4)
		print(j) // 1234
	if (i in 1..10) { // equivalent of 1 <= i && i <= 10
		println(i) // 2
	}
}