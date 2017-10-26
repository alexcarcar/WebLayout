console.log("---- Data Conversion (p. 52) ----");

const numStr = "33.3";
const num = Number(numStr);
console.log(num, Number("Abc ?"));
console.log(parseInt("16 volts", 10));
console.log(parseInt("3a", 16)); // 3*16 + 10 = 48+10 = 58
console.log(parseFloat("15.5 kph"));

const d = new Date();
const ts = d.valueOf(); // milliseconds since Jan 1, 1970 midnight UTC
console.log(ts);
const b = true;
const n = b ? 1 : 0;
console.log(n);

const n2 = 33.5;
const s = n2.toString();
console.log(s); // "33.5"
const arr = [1, true, "hello"];
console.log(arr.toString());

const nn = 0;
const bb1 = !!nn;
const bb2 = Boolean(n);
console.log(nn==true, bb1, bb2);