// 10:23

let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let n = Number(input[0]);
let answer = '';
for(let i = 1; i <= 9; i++) {
    answer += `${n} * ${i} = ${n*i}\n`;
}

console.log(answer);
