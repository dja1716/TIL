//9:48

let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let curH = Number(input[0].split(' ')[0]);
let curM = Number(input[0].split(' ')[1]);
let cookM = Number(input[1]);

function cookFinishAt(curH, curM, cookM) {
    let cookH = parseInt(cookM / 60);
    cookM %= 60;
    let answerH = 0;
    let answerM = 0;
    if(cookM + curM < 60) {
        answerM = cookM + curM;
    } else {
        answerM = (cookM + curM) % 60;
        cookH += 1;
    }

    if(cookH + curH < 24) {
        answerH = cookH + curH;
    } else {
        answerH = cookH + curH - 24;
    }

    console.log(`${answerH} ${answerM}`);
}
cookFinishAt(curH, curM, cookM);
