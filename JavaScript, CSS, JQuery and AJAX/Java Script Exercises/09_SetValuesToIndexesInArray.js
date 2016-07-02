'use strict';

function solved(arr) {
    let n = Number(arr[0])
    let dict = []
    for (let i = 1; i < arr.length; i++) {
        let line = arr[i].split(' - ')
        let index = line[0]
        let value = line[1]
        dict[index] = value
    }
    for (let i = 0; i < n; i++) {
        if (dict[i] != undefined) console.log(dict[i])
        else console.log(0)
    }
}

solved([2, '0 - 5', '0 - 6', '0 - 7'])