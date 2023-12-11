// 10:04
let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let [d1, d2, d3] = input[0].split(' ').map(Number);
function calculateAward(d1, d2, d3) {
    let award = 0;
    if(d1 === d2 && d3 === d2) {
        award = 10000 + d1 * 1000;
    } else if (d1 === d2) {
        award = 1000 + d1 * 100;
    } else if (d2 === d3) {
        award = 1000 + d2 * 100;
    } else if (d1 === d3) {
        award = 1000 + d1 * 100;
    } else {
        award = Math.max(d1, d2, d3) * 100;
    }
    console.log(award);
}
calculateAward(d1, d2, d3);
