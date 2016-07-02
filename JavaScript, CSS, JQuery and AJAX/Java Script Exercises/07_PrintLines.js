'use strict';

function solved (arr){

    for (let i = 0; i < arr.length; i++){
        if (arr[i] != "Stop") console.log(arr[i])
        else break
    }
}

solved([123, 2345, 'Stop', 4345])