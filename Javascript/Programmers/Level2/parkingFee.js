function solution(fees, records) {
    const baseTime = fees[0];
    const baseFee = fees[1];
    const rateTime = fees[2];
    const rateFee = fees[3];
    const recordInMap = {};
    const recordOutMap = {};
    const recordOrder = [];
    var answer = [];
    
    for(let i = 0; i < records.length; i++) {
        // 0 time
        // 1 plat_number
        // 2 in/out
      
        const row = records[i].split(' ');
        if(row[2] === 'IN') {
            if(recordInMap[row[1]]) {
                recordInMap[row[1]].push(row[0]);
            } else {
                
            recordInMap[row[1]] = [row[0]];
            }
            recordOrder.push(row[1]);
        } else {
            if(recordOutMap[row[1]]) {
                recordOutMap[row[1]].push(row[0]);
            } else {
                
            recordOutMap[row[1]] = [row[0]];
            }
        }
    }
    recordOrder.sort();
    let prevPlate;
    
    for(let i = 0; i < recordOrder.length; i++) {
        if(recordOrder[i] === prevPlate) continue;
        prevPlate = recordOrder[i];
        let totalMinute = 0;
        let totalFee = 0;
        while(recordInMap[recordOrder[i]].length > 0) {
            const timeIn = recordInMap[recordOrder[i]].shift();
            let timeOut;
            if(recordOutMap[recordOrder[i]]?.length > 0) {
                timeOut = recordOutMap[recordOrder[i]].shift();
            } else {
                timeOut = '23:59';
            }
            const hour = Number(timeOut.split(':')[0]) - Number(timeIn.split(':')[0]);
            const minute = Number(timeOut.split(':')[1]) - Number(timeIn.split(':')[1]);
            totalMinute += hour * 60 + minute;

        }
        totalFee += baseFee;
        if(totalMinute > baseTime) {
            totalFee += Math.ceil((totalMinute - baseTime) / rateTime) * rateFee;
        } 
        answer.push(totalFee);
        
        
    }
    return answer;
}
