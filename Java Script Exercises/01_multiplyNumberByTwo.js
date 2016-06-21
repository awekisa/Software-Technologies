'use strict';
let arr = ["1"]
solved(arr)
function solved(arr){
    let number = Number(arr[0])
    console.log(multiply(number))
    function multiply(number) {return number * 2};
}

