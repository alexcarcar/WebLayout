console.log("=== Functions as Subroutines (p 180)");
function isLeapYear(y) {
	const year = (typeof y === 'undefined') ? new Date().getFullYear() : y;
	if (year%4 !==0) return false;
	else if (year%100 !==0) return true;
	else if (year%400 !==0) return false;
	else return true;
}
function printLeapYearStatus(y) {
	const year = (typeof y === 'undefined') ? new Date().getFullYear() : y;
	if (isLeapYear(year)) {
		console.log(`${year} IS a leap year`);
	} else {
		console.log(`${year} is NOT a leap year.`);
	}
}
printLeapYearStatus();
printLeapYearStatus(2016);
printLeapYearStatus(2018);
const daysInMonth = [31, isLeapYear()?29:28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
const daysInMonth2016 = [31, isLeapYear(2016)?29:28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
console.log(daysInMonth);
console.log(daysInMonth2016);

console.log("=== Functions as ... Functions");
const colors = ['red', 'green', 'blue'];
let colorIndex = -1;
function getNextColor() {
	if(++colorIndex >= colors.length) colorIndex = 0;
	return colors[colorIndex];
}
console.log(getNextColor());
console.log(getNextColor());
console.log(getNextColor());
console.log(getNextColor());
console.log(getNextColor());

console.log("=== Putting external variables in a closure (p 186)");
const getNextRainbowColor = (function(){
	const colors = ['orange', 'yellow', 'purple'];
	let colorIndex = -1;
	return function() {
		if(++colorIndex >= colors.length) colorIndex=0;
		return colors[colorIndex];
	};
})();
console.log(getNextRainbowColor());
console.log(getNextRainbowColor());
console.log(getNextRainbowColor());
console.log(getNextRainbowColor());
console.log(getNextRainbowColor());
