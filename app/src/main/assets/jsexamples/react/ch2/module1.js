// export can be used to export any JavaScript type that will be consumed in another
// module. In this example the print function and log function are being exported.

const print = function(message) {
	log(message, new Date())
}
const log = function(message, timestamp=(new Date())) {
	console.log(`${timestamp.toString()}: ${message}`)
} 
module.exports = {print, log}