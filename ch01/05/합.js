// 10:15
let fs = require('fs');


let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let n = Number(input[0]);

function solution1(n) {
        let answer = 0;
    for(let i = 1; i <= n; i++) {
        answer += i;
    }
    console.log(answer);
}

// 등차수열 사용 n(s + l) / 2
function solution2(n) {
    let answer = n(1 + n) / 2;
    console.log(answer);
}

solution1(n);
