let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const a = Number(input[0].split(' ')[0]);
const b = Number(input[0].split(' ')[1]);

const answer = `${a+b}\n${a-b}\n${a*b}\n${parseInt(a/b)}\n${a%b}\n`
console.log(answer);
