'use strict';

function solved (arr){
    let obj = {}
    for (let i = 0; i < arr.length; i++){
    let elements = arr[i].split(' -> ')
        let key = elements[0]
        let value = TryParseInt(elements[1], elements[1])

        obj[key] = value
    }
    console.log(JSON.stringify(obj))

    function TryParseInt(str,defaultValue) {
        let retValue = defaultValue;
        if(str !== null) {
            if(str.length > 0) {
                if (!isNaN(str)) {
                    retValue = parseInt(str);
                }
            }
        }
        return retValue;
    }
}

solved([
    'name -> Angel',
    'surname -> Georgiev',
    'age -> 20',
    'grade -> 6.00',
    'date -> 23/05/1995',
    'town -> Sofia'

])