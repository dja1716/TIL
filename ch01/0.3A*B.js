let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let answer = input[0].split(' ')[0] * input[0].split(' ')[1];

console.log(answer);
