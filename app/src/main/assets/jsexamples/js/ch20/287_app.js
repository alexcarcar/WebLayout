const debug1 = require('./myDebugLogger')('one');
const debug2 = require('./myDebugLogger')('two');

debug1('started first debugger!');
debug2('started second debugger!');

setTimeout(function(){
	debug1('after some time...');
	debug2('what happens?'); // shares the same lastMessage variable
},200);

/*
one started first debugger! +0ms
two started second debugger! +156ms
one after some time... +219ms
two what happens? +0ms
*/