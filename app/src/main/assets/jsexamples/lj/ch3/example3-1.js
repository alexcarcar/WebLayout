// example3-1.js

// p. 34
let currentTempC = 22; // degrees Celsius
currentTempC = 22.5;
console.log(currentTempC); // 22.5

let targetTempC;
console.log(targetTempC); // undefined

// multiple variables with same let statement
let room1 = "conference_room_a", room2 = "lobby"; 

const ROOM_TEMP_C = 21.5, MAX_TEMP_C = 30;
// ROOM_TEMP_C = 3; // TypeError: Assignment to constant variable.
// const NEW_K; // SyntaxError: Missing initializer in const declaration