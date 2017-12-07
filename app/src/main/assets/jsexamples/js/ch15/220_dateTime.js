console.log("=== Date and Time (p 220)");
const d = new Date();
console.log(d); // formatted Gregorian date with TZ
console.log(d.valueOf()); // milliseconds since Unix Epoch
console.log("=== Date and Time (p 221)");
console.log(new Date(2015, 0)); // Jan 1, 2015 12:00 AM (UTC)
console.log(new Date(2015, 1)); // Feb 1, 2015 12:00 AM
console.log(new Date(2015, 1, 14)); // Feb 14, 2015 12:00 AM
console.log(new Date(2015, 1, 14, 13)); // Feb 14, 2015 1:00 PM
console.log(new Date(2015, 1, 14, 13, 30)); // Feb 14, 2015 1:30 PM
console.log(new Date(2015, 1, 14, 13, 30, 5)); // Feb 14, 2015 1:30:05 PM
console.log(new Date(2015, 1, 14, 13, 30, 5, 500)); // Feb 14, 2015 1:30:05.500 PM
console.log("=== Creating dates from Unix Epoch (1970 Jan 1)");
console.log(new Date(0), new Date(1000), new Date(1463443200000)); // 1970 Jan 1 (basis)
console.log(new Date(-365*24*60*60*1000)); // 1969 Jan 1
console.log("=== Parsing date strings (defaults to local time)");
console.log(new Date("June 14, 1903"), new Date("June 14, 1903 GMT-0000"));
/*
=== Date and Time (p 220)
2017-12-07T14:30:21.142Z
1512657021142
=== Date and Time (p 221)
2015-01-01T08:00:00.000Z
2015-02-01T08:00:00.000Z
2015-02-14T08:00:00.000Z
2015-02-14T21:00:00.000Z
2015-02-14T21:30:00.000Z
2015-02-14T21:30:05.000Z
2015-02-14T21:30:05.500Z
=== Creating dates from Unix Epoch (1970 Jan 1)
1970-01-01T00:00:00.000Z 1970-01-01T00:00:01.000Z 2016-05-17T00:00:00.000Z
1969-01-01T00:00:00.000Z
=== Parsing date strings (defaults to local time)
1903-06-14T07:00:00.000Z 1903-06-14T00:00:00.000Z
*/