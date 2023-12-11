function solution(want, number, discount) {
    var answer = 0;
    const m = {};
    for(let i = 0; i < want.length; i++) {
        m[want[i]] = number[i];
    }
    for(let i = 0; i < discount.length; i++) {
        if(discount.length - i < 10) break;
        let clone = {};
        Object.assign(clone, m);
        let tempBool = true;
        for(let j = 0; j < 10; j++) {
            if(!clone[discount[i + j]]) {
                tempBool = false;
            } else {
                clone[discount[i + j]] -= 1;
            }
        }
        if(tempBool === true) answer++;
        
    }
    return answer;
}
