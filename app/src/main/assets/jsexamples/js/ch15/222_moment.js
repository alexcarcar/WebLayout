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

console.log("=== Using numerical values to pass dates");
const beforeN = { d: new Date().valueOf() };
const jsonN = JSON.stringify(beforeN);
const afterN = JSON.parse(jsonN);
const dN = new Date(after.d);
console.log(typeof beforeN.d, typeof afterN.d, dN);

console.log("=== Displaying Dates");
const d30 = new Date(Date.UTC(1930, 4, 10));
console.log(d30.toLocaleDateString(), d30.toLocaleTimeString());
console.log(d30.toTimeString(), d30.toUTCString());
console.log(moment(d30).format("YYYY-MM-DD"));
console.log(moment(d30).format("YYYY-MM-DD HH:mm"));
console.log(moment(d30).format("YYYY-MM-DD HH:mm Z"));
console.log(moment(d30).format("YYYY-MM-DD HH:mm [UTC]Z"));
console.log(moment(d30).format("dddd, MMMM [the] Do, YYYY"));
console.log(moment(d30).format("h:mm a"));

console.log("=== Date Components");
console.log(d30.getFullYear(), d30.getMonth(), d30.getDate(), d30.getDay());
console.log(d30.getHours(), d30.getMinutes(), d30.getSeconds(), d30.getMilliseconds());
console.log(d30.getUTCFullYear(), d30.getUTCMonth(), d30.getUTCDate());

console.log("=== Comparing Dates (p 226)");
const d1 = new Date(1996, 2, 1);
const d2 = new Date(2009, 4, 27);
console.log(d1, d2, d1>d2, d1<d2);

console.log("=== Date Arithmetic (p 226)");
const msDiff = d2 -d1;
const daysDiff = msDiff/1000/60/60/24;
console.log(msDiff, daysDiff);
const dates = [];
const min = new Date(2017, 0, 1).valueOf();
const delta =  new Date(2020, 0, 1).valueOf() - min;
console.log("min", min, "delta", delta);
for(let i=0; i<10; i++) {
	dates.push(new Date(min + delta*Math.random()))
}
console.log(dates);
dates.sort((a,b) => b-a);
console.log(dates);
dates.sort((a,b) => a-b);
console.log(dates);

console.log("=== Moment Arithmetic (p227)");
const m = moment();
console.log("now:", m);
m.add(3, 'days');
console.log("+3 days:", m);
m.subtract(2, 'years');
console.log("-2 years:", m);
m.startOf('year');
console.log("start of the year", m);
m.endOf('month');
console.log("end of the month", m);
const m2 = moment().add(10, 'hours').subtract(3, 'days').endOf('month');
console.log("now +10h -3days end of month:", m2);


console.log("=== User-Friendly Relative Dates (p 227)");
console.log(moment().subtract(10, 'seconds').fromNow());
console.log(moment().subtract(44, 'seconds').fromNow());
console.log(moment().subtract(45, 'seconds').fromNow());
console.log(moment().subtract(5, 'minutes').fromNow());
console.log(moment().subtract(45, 'minutes').fromNow());
console.log(moment().subtract(10, 'days').fromNow());

/*
=== Moment.js (p 222)
UTC 2016-05-27T00:00:00.000Z
LA 2016-04-27T16:19:00.000Z
=== Transmitting Dates (p 223)
true
{"d":"2017-12-09T15:54:47.329Z"} { d: '2017-12-09T15:54:47.329Z' }
2017-12-09T15:54:47.329Z false string
2017-12-09T15:54:47.329Z true 'object'
=== Using numerical values to pass dates
number number 2017-12-09T15:54:47.329Z
=== Displaying Dates
5/9/1930 4:00:00 PM
17:00:00 GMT-0700 (Pacific Daylight Time) Sat, 10 May 1930 00:00:00 GMT
1930-05-09
1930-05-09 17:00
1930-05-09 17:00 -07:00
1930-05-09 17:00 UTC-07:00
Friday, May the 9th, 1930
5:00 pm
=== Date Components
1930 4 9 5
17 0 0 0
1930 4 10
=== Comparing Dates (p 226)
1996-03-01T08:00:00.000Z 2009-05-27T07:00:00.000Z false true
=== Date Arithmetic (p 226)
417740400000 4834.958333333333
min 1483257600000 delta 94608000000
[ 2018-04-23T09:27:02.253Z,
  2018-03-14T16:51:51.605Z,
  2018-09-16T18:07:19.917Z,
  2018-04-21T14:51:03.803Z,
  2019-01-22T12:24:40.110Z,
  2017-06-03T20:54:31.343Z,
  2019-12-29T23:16:08.607Z,
  2017-02-16T14:42:34.361Z,
  2017-08-24T09:47:29.274Z,
  2017-12-04T09:14:13.919Z ]
[ 2019-12-29T23:16:08.607Z,
  2019-01-22T12:24:40.110Z,
  2018-09-16T18:07:19.917Z,
  2018-04-23T09:27:02.253Z,
  2018-04-21T14:51:03.803Z,
  2018-03-14T16:51:51.605Z,
  2017-12-04T09:14:13.919Z,
  2017-08-24T09:47:29.274Z,
  2017-06-03T20:54:31.343Z,
  2017-02-16T14:42:34.361Z ]
[ 2017-02-16T14:42:34.361Z,
  2017-06-03T20:54:31.343Z,
  2017-08-24T09:47:29.274Z,
  2017-12-04T09:14:13.919Z,
  2018-03-14T16:51:51.605Z,
  2018-04-21T14:51:03.803Z,
  2018-04-23T09:27:02.253Z,
  2018-09-16T18:07:19.917Z,
  2019-01-22T12:24:40.110Z,
  2019-12-29T23:16:08.607Z ]
=== Moment Arithmetic (p227)
now: moment("2017-12-09T07:54:47.938")
+3 days: moment("2017-12-12T07:54:47.938")
-2 years: moment("2015-12-12T07:54:47.938")
start of the year moment("2015-01-01T00:00:00.000")
end of the month moment("2015-01-31T23:59:59.999")
now +10h -3days end of month: moment("2017-12-31T23:59:59.999")
=== User-Friendly Relative Dates (p 227)
a few seconds ago
a few seconds ago
a minute ago
5 minutes ago
an hour ago
10 days ago
*/