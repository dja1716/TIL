function solution(queue1, queue2) {
    var answer = 0;
    let queueSum1 = 0;
    let queueSum2 = 0;
    let pointer1 = 0;
    let pointer2 = 0;
    let found = false;
    for(let i = 0; i < queue1.length; i++) {
        queueSum1 += queue1[i];
        queueSum2 += queue2[i];
    }
    while(answer <= 600000) {
        if(queueSum1 == queueSum2) {
            found = true;
            break;
        }
        answer++;
        if(queueSum1 > queueSum2) {
            let popElem = queue1[pointer1];
            queueSum1 -= popElem;
            queueSum2 += popElem;
            queue2.push(popElem);
            pointer1++;
        } else {
            let popElem = queue2[pointer2];
            queueSum2 -= popElem;
            queueSum1 += popElem;
            queue1.push(popElem);
            pointer2++;
        }
    }
    if(!found) return -1;
    
    return answer;
}
