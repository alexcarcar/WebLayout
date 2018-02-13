let a="", b="", operator="";
let newProblem=true;

function getRes() {
    return document.getElementById("res").innerHTML;
}

function setRes(x) {
    document.getElementById("res").innerHTML = x;
}

function btn0() {
    if (newProblem) {
        setRes("");
        newProblem = false;
        a=b=operator="";
    }
    let res = getRes()+"0";
    setRes(res);
    if (operator=="") {
        a+="0";
    } else {
        b+="0";
    }
}

function btn1() {
    if (newProblem) {
        setRes("");
        newProblem = false;
        a=b=operator="";
    }
    let res = getRes()+"1";
    setRes(res);
    if (operator=="") {
        a+="1";
    } else {
        b+="1";
    }
}

function btnClr() {
    setRes("");
    a = b = operator = "";
}

function btnEql() {
    if (newProblem) return;
    let aVal = (a==""?0:parseInt(a,2));
    let bVal = (b==""?0:parseInt(b,2));
    let ans = 0;
    switch(operator) {
        case "+": ans = aVal+bVal; break;
        case "-": ans = aVal-bVal; break;
        case "*": ans = aVal*bVal; break;
        case "/": ans = aVal/bVal; break;
        default: ans = aVal;
    }
    let binaryAns = ans.toString(2);
    setRes(binaryAns);
    a = binaryAns;
    b = "";
    operator = "";
    newProblem = true;
}

function btnSum() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "+";
    setRes("");
}

function btnSub() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "-";
    setRes("");
}

function btnMul() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "*";
    setRes("");
}

function btnDiv() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "/";
    setRes("");
}

/*
[Test: CSS constraints]. [Result: Success]. [Score: 12.00]
[Test: Click sequence of 111100001]. [Result: Success]. [Score: 15.00]
[Test: Click sequence of +11110]. [Result: Failure]. [Score: 15.00]
[Test: Click =]. [Result: Success]. [Score: 18.00]
[Test: Click sequence of 111*]. [Result: Failure]. [Score: 18.00]
[Test: Click sequence of 1001001=]. [Result: Failure]. [Score: 18.00]
[Test: Click sequence of C1001]. [Result: Success]. [Score: 21.00]
*/