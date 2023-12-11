

function helper(arr, tangerines, countBySize) {
    for(let i = 0; i < arr.length; i++) {
        if(tangerines[arr[i]] === undefined) {
            tangerines[arr[i]] = 0;
        } 
        tangerines[arr[i]] += 1;
    }
    for(t in tangerines) {
        if(countBySize[tangerines[t]] === undefined) {
            countBySize[tangerines[t]] = 0;
        }
        countBySize[tangerines[t]] += 1;
    }
}

function solution(k, tangerine) {
    var answer = 0;
    let arr = [];
    const tangerines = {};
    const countBySize = {};
    
    helper(tangerine, tangerines, countBySize);
    for(c in countBySize) {
        
        for(let i = 0; i < countBySize[c]; i++) {
            arr.unshift(c);
        }
        
    }
    while(k > 0) {
        answer++;
        const count = arr.shift();
        k -= count;
    }
    
    return answer;
}
