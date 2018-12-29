// Modules can be consumed in other JavaScript files using the import statement. Modules
// with multiple exports can take advantage of object destructuring. Modules that
// use export default are imported into a single variable:
const { log, print } = require('./module1')
const { freel } = require('./module2')

print("hello")
log("log entry")
freel.print()

// Sat Dec 29 2018 10:41:36 GMT-0800 (Pacific Standard Time): hello
// Sat Dec 29 2018 10:41:36 GMT-0800 (Pacific Standard Time): log entry
// Mt. Freel will take 2 days.
// Bring your water and your snack.
