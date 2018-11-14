function countSpaces(str) {
	return str.split(' ').length - 1;
}

let s1 = "This is a test."; // 3
console.log(countSpaces(s1));
let s2 = "This is a  test."; // 4
console.log(countSpaces(s2));
let s3 = "  "; 
console.log(countSpaces(s3)); // 2
console.log(s3.split(' ')); // [ '', '', '' ]
