function solution(cards1, cards2, goal) {
    let indexForCard1 = 0;
    let indexForCard2 = 0;
    
    for(let i = 0; i < goal.length; i++) {
        if(goal[i] !== cards1[indexForCard1] && goal[i] !== cards2[indexForCard2]) {
            return 'No'
        }
        if(goal[i] === cards1[indexForCard1]) {
            indexForCard1++;
        }
        if(goal[i] === cards2[indexForCard2]) {
            indexForCard2++;
        }
    }
    return 'Yes';
}
