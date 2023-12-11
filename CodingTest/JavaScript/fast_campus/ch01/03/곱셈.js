let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let firstNum = Number(input[0]);
let secondLine = input[1];

let answer = '';

answer += `${firstNum * Number(secondLine[2])}\n`;
answer += `${firstNum * Number(secondLine[1])}\n`;
answer += `${firstNum * Number(secondLine[0])}\n`;
answer += `${firstNum * Number(secondLine)}\n`;

console.log(answer);
