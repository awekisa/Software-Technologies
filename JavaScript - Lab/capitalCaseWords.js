'use strict';

function solve(arr){
    let text = arr.join(',')
    let words = text.split(/\W+/).filter(word => word != "").filter(word => word == word.toUpperCase())

    console.log(words.join(', '))
}

solve(['sds Ssdsd ZXCZXC ZXC',   ', , , ,aaffsdf AWE S.'])