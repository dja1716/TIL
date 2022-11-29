const sortNumDesc = (a, b) => {
    if(a < b) return 1;
    if(a === b) return 0;
    if(a > b) return -1;
}

const gcd = (a, b) => {
    if(a == 0) return b;
    return gcd(b % a, a);
}

const findCDs = (arr) => {
    const N = arr.length;
    
    let g = arr[0];

    let divisors = new Set();

    for(let i = 1; i < N; i++) {
        g = gcd(arr[i], g);
    }
    for(let i = 1; i * i <= g; i++) {
        if(g % i == 0) {
            divisors.add(i);
            if(Math.floor(g / i) != i) {
                divisors.add(Math.floor(g / i));
            }
        }
    }
    
    return divisors;
    
}


function solution(arrayA, arrayB) {
    
    var answer = 0;
    let cdA = findCDs(arrayA);
    let cdB = findCDs(arrayB);
    cdA = Array.from(cdA).sort(sortNumDesc);
    cdB = Array.from(cdB).sort(sortNumDesc);
    cdA.pop();
    cdB.pop();
    for(let i = 0; i < cdA.length; i++) {
        let tempB = true;
        for(let j = 0; j < arrayB.length; j++) {
            if(cdA[i] <= arrayB[j] && arrayB[j] % cdA[i] == 0) {
                tempB = false;
                break;
            }
        }
        if(tempB  && cdA[i] > answer) {
            answer = cdA[i];
            break;
        }
    }
    
    for(let i = 0; i < cdB.length; i++) {
        let tempB = true;
        for(let j = 0; j < arrayA.length; j++) {
            if(cdB[i] <= arrayA[j] && arrayA[j] % cdB[i] == 0) {
                tempB = false;
                break;
            }
        }
        if(tempB && cdB[i] > answer) {
            answer = cdB[i];
            break;
        }
    }
    return answer;
}
