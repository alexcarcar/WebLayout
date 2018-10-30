fun main(args:Array<String>) {
	var programmer:Human = object:Human {
		override fun think() {
			print("I am thinking")
		}
	}
	programmer.think()
}
interface Human {
	fun think()
}

// I am thinking

// ### Examples of typealiases
typealias NodeSet = Set<Network.Node>
typealias FileTable<K> = MutableMap<K, MutableList<File>>
class Network {class Node {}}
class File {}
