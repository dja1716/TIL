// 10:36

let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let n = Number(input[0]);
let answer = '';
for(let i = 1; i <= n; i++) {
    answer += `${Number(input[i].split(' ')[0]) + Number(input[i].split(' ')[1])}\n`;
}

console.log(answer.slice(0, -1));
