// https://www.tutorialspoint.com/kotlin/kotlin_exception_handling.htm
// 
// Kotlin - Exception Handling
// ==============================================================
// All exceptions are descendants of the "Throwable" class

fun main(args: Array<String>) {
	try {
		val myVar:Int = 12;
		println(myVar);
		val v:String = "Another String";
		println(v);
		v.toInt(); // will throw an exception
	} catch(e:Exception) {
		e.printStackTrace();
	} finally {
		println("Exception handling in Kotlin");
	}
}

/*
12
Another String
java.lang.NumberFormatException: For input string: "Another String"
        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        at java.lang.Integer.parseInt(Integer.java:580)
        at java.lang.Integer.parseInt(Integer.java:615)
        at ExceptKt.main(except.kt:13)

Exception handling in Kotlin
 */