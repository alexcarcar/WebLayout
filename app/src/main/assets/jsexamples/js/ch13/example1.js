$(document).ready(function() {
	'use strict';
	const log = console.log;
	log("---------------------------------");

	/*function printLeapYearStatus(){
		const year = new Date().getFullYear();
		if(year%4 !== 0) {
			log(`${year} is NOT a leap year.`);
		} else if (year%100 != 0) {
			log(`${year} IS a leap year.`);
		} else if (year%400 != 0) {
			log(`${year} is NOT a leap year.`);
		} else {
			log(`${year} IS a leap year.`);
		}
	}
	printLeapYearStatus();
	log("---------------------------------");
	setTimeout(function() {
		console.log("hello");
	}, 1500);
	var i;
	for(i=5;i>=0;i--) {
		setTimeout(function(){
			console.log(i===0 ? "go!" : i);
		}, (5-i)*1000);
	}
	log("---------------------------------");
	function loopBody(i) {
		setTimeout(function(){
			log(i===0 ? "go!":i);
		},(5-i)*1000);
	}
	var i;
	for(i=5;i>0;i--){
		loopBody(i);
	} */
	log("---------------------------------");
	function addThreSquareAddFiveTakeSquareRoot(x) {
		return Math.sqrt(Math.pow(x+3,2)+5);
	}
	const f = addThreSquareAddFiveTakeSquareRoot;
	const answer = (f(5)+f(2))/f(7);
	log(answer);
	log("---------------------------------");
	const sin = Math.sin;
	const cos = Math.cos;
	const theta = Math.PI/4;
	const zoom = 2;
	const offset = [1, -3];

	const pipeline = [
		function rotate(p) {
			return {
				x: p.x*cos(theta) - p.y*sin(theta),
				y: p.x*sin(theta) + p.y*cos(theta)
			};
		},
		function scale(p) {
			return {x:p.x*zoom, y:p.y*zoom};
		},
		function translate(p) {
			return {x:p.x+offset[0],y:p.y+offset[1]};
		}
	];
	const p = {x:1,y:1};
	let p2=p;
	for(let i=0;i<pipeline.length;i++){
		p2 = pipeline[i](p2);
	}
	log(p2);
	log("---------------------------------");
	function sum(arr, f){
		if(typeof f != 'function') f = x => x;
		return arr.reduce((a,x) => a += f(x), 0);
	}
	log(sum([1,2,3]));
	log(sum([1,2,3], x=>x*x));
	log(sum([1,2,3], x=>Math.pow(x,3)));
	log("---------------------------------");
	function newSummer(f) {
		return arr => sum(arr, f);
	}
	const sumOfSquares = newSummer(x=>x*x);
	const sumOfCubes = newSummer(x=>Math.pow(x,3));
	log(sumOfSquares([1,2,3]));
	log(sumOfCubes([1,2,3]));
	log("---------------------------------");
	function findNeedle(haystack){
		if(haystack.length===0) return "no haystack here!";
		if(haystack.shift()==='needle') return "found it!";
		return findNeedle(haystack);
	}
	log(findNeedle(['hay', 'hay', 'needle', 'hay']));
	log("---------------------------------");
	function fact(n){
		if(n===1)return 1;
		return n*fact(n-1);
	}
	log(fact(7));
	log("---------------------------------");

});