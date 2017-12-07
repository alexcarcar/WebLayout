const moment = require('moment-timezone');

console.log("=== Moment.js (p 222)");
let d = new Date(Date.UTC(2016, 4, 27)); // May 27, 2016 UTC
console.log("UTC", d);
d = moment.tz([2016, 3, 27, 9, 19], 'America/Los_Angeles').toDate();
console.log("LA", d);

console.log("=== Transmitting Dates (p 223)");
/*
=== Moment.js (p 222)
UTC 2016-05-27T00:00:00.000Z
LA 2016-04-27T16:19:00.000Z
=== Transmitting Dates (p 223)
*/