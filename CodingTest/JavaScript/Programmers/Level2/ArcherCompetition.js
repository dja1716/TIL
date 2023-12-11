let initialState = {
  left: 0,
  score: 0,
  arr: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
  oppScore: 0,
};
let curState = {};
let winState = {};
let count = [];

function addBrianScore(i) {
  curState.left -= count[i] + 1;
  curState.arr[i] = count[i] + 1;
  curState.score += 10 - i;
}

function scoreCalculate(state) {
  return state.score - state.oppScore;
}

function leftCollector() {
  curState.arr[10] = curState.left;
  curState.left = 0;
}

function helper(i) {
  if (i != 0) {
    let temp = {
      left: curState.left,
      score: curState.score,
      arr: curState.arr.slice(),
      oppScore: curState.oppScore,
    };
    if (curState.left > count[i]) {
      if (count[i] == 0) {
        addBrianScore(i);
        helper(i - 1);
        curState = temp;
      } else {
        addBrianScore(i);
        curState.oppScore -= 10 - i;
        helper(i - 1);
        curState = temp;
      }
    }
    helper(i - 1);
  } else {
    if (curState.left > count[0]) {
      if (count[0] == 0) {
        addBrianScore(i);
        leftCollector();
      } else {
        addBrianScore(i);
        curState.oppScore -= 10 - i;
        leftCollector();
      }
    }
    if (scoreCalculate(curState) > scoreCalculate(winState)) {
      winState = curState;
    }
  }
}

function solution(n, info) {
  let answer;
  let opponentScore = 0;
  count = info;

  for (let i = 0; i < info.length; i++) {
    if (info[i] > 0) {
      opponentScore += 10 - i;
    }
  }
  initialState.left = n;
  initialState.score = 0;
  initialState.oppScore = opponentScore;
  winState.score = 0;
  winState.oppScore = opponentScore;
  for (let i = 10; i >= 0; i--) {
    curState = initialState;
    helper(i);
  }
  if (scoreCalculate(winState) > 0) {
    answer = winState.arr;
  } else {
    answer = [-1];
  }
  return answer;
}
