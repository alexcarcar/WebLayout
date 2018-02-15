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
    setRes(getRes()+"+");
}

function btnSub() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "-";
    setRes(getRes()+"-");
}

function btnMul() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "*";
    setRes(getRes()+"*");
}

function btnDiv() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "/";
    setRes(getRes()+"/");
}let a="", b="", operator="";
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
    setRes(getRes()+"+");
}

function btnSub() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "-";
    setRes(getRes()+"-");
}

function btnMul() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "*";
    setRes(getRes()+"*");
}

function btnDiv() {
    if (newProblem) {
        a = getRes();
        newProblem = false;
    }
    operator = "/";
    setRes(getRes()+"/");
}