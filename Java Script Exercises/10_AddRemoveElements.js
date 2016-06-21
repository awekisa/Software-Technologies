'use strict';

function solved(arr) {
    let list = []
    for (let i = 0; i < arr.length; i++) {
        let line = arr[i].split(' ')
        let command = line[0]
        let value = line[1]
        if (command == "add"){
            list.push(value)
        }
        else{
            list.splice(Number(value), 1)
        }
    }
    for (let i = 0; i < list.length; i++){
    console.log(list[i])
    }
}

solved(['add 3', 'add 5', 'remove 1', 'add 2'])

