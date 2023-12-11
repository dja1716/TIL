// 10:29

let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let n = Number(input[0]);

let curStar = '';
let answer = '';
for(let i = 1; i <= n; i++) {
    curStar += '*';
    answer += curStar + '\n';
}
console.log(answer);
