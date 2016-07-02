'use strict';

function solved(arr) {
    let dict = []
    for (let i = 0; i < arr.length; i++) {
        let elements = arr[i].split(' ').filter(e => e != "")
        if (elements.length > 1) {
            let key = elements[[0]]
            let value = elements[1]
            dict[key] = value
        }
        else{
            let key = elements[0]
            if (key in dict){
                console.log(dict[key])
            }
            else{
                console.log("None")
            }
        }
    }
}

solved(["key value",
    "key eulav",
    "test tset",
    "key"])