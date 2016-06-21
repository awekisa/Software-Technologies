'use strict';

function solved(arr) {
    let people = []
    for (let i = 0; i < arr.length; i++) {
        let elements = arr[i].split(' -> ')
        let name = elements[0]
        let age = elements[1]
        let grade = elements[2]
        let str = '{ "Name" : "' + name + '", "Age" : ' + age + ', "Grade" : "' + grade + '" }'
        let obj = JSON.parse(str)
        people.push(obj)
    }
    for (let obj of people){
        console.log("Name: " + obj.Name)
        console.log("Age: " + obj.Age)
        console.log("Grade: " + obj.Grade)
    }
}

solved(['pesha -> 23 -> 1.00'])