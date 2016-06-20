"use strict";
solve(['15', '8', '7'])
function solve(args) {
    let arr = args[0].split(' ').map(Number)
    arr.sort(function (a, b){return a-b})
    let a = Number(arr[0])
    let b = Number(arr[1])
    let c = Number(arr[2])
    if (a + b == c){
        console.log(a + " + " + b + " = " + c)
    }
        else if (a + c == b){
        console.log(a + " + " + c + " = " + b)
    }
        else if (b + c == a){
        console.log(b + " + " + c + " = " + a)
    }
    else{
        console.log('No')
    }
}
