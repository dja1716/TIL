let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

const score = Number(input[0]);
let answer;
if(score >= 90) {
    answer = 'A';
} else if (score >= 80) {
    answer = 'B';
} else if (score >= 70) {
    answer = 'C';
} else if (score >= 60) {
    answer = 'D';
} else {
    answer = 'F';
}

console.log(answer);
