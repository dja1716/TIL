// 9:38
let fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString().split('\n');

let hour = Number(input[0].split(' ')[0]);
let minute = Number(input[0].split(' ')[1]);

function alarm(hour, minute) {
    // min >= 45
    // min < 45
    if(minute >= 45) {
        minute -= 45;
    } else {
        minute += 15;
        if(hour === 0) {
            hour = 23;
        } else {
            hour -= 1;
        }
    }
    
    console.log(`${hour} ${minute}`);
}

alarm(hour, minute);
