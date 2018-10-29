fun main(args: Array<String>) {
	var x:Int = 0
	do {
		x = x + 10
		print("..."+x)
	} while (x <= 50)
	println()
	// ...10...20...30...40...50...60

	var y:Int = 0
	while(y <= 10) {
		print("..."+y)
		y++
	}
	println()
	// ...0...1...2...3...4...5...6...7...8...9...10
}