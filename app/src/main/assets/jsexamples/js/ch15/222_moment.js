const moment = require('moment-timezone');

console.log("=== Moment.js (p 222)");
let d = new Date(Date.UTC(2016, 4, 27)); // May 27, 2016 UTC
console.log("UTC", d);
d = moment.tz([2016, 3, 27, 9, 19], 'America/Los_Angeles').toDate();
console.log("LA", d);

console.log("=== Transmitting Dates (p 223)");
const before = {d: new Date()};
console.log(before.d instanceof Date);
const json = JSON.stringify(before);
const after = JSON.parse(json);
console.log(json, after);
console.log(after.d, after.d instanceof Date, typeof after.d);
after.d = new Date(after.d);
console.log(after.d, after.d instanceof Date, typeof after.d);
