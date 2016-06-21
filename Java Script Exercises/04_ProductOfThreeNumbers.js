'use strict';

function solved(arr){
    let nums = arr.map(Number)
    let posit = []
    let negat = []
    if (nums.indexOf(0) > -1) console.log("Positive")
    else {
        for (let num of nums) {
            if (num < 0) negat.push(num)
            else posit.push(num)
        }
        if (negat.length % 2 == 0) console.log("Positive")
        else console.log("Negative")
    }
}

solved([2, -3, -1])