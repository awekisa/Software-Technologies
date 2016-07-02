"use strict";
symetricNumber([10000])
function symetricNumber(args) {
    let n = Number(args[0]), result = ''
    for (let i = 1; i <= n; i++)
        if (isPalindrome("" + i)) {
            result += i + " "
        }
    console.log(result)

    function isPalindrome(i) {
        let bool = true;
        for (let j = 0; j <= i.length / 2; j++) {
            let a = Number(i[j])
            let b = Number(i[i.length - 1 - j])
            if (a != b) {
                bool = false
                break
            }
        }
            return bool
    }
}