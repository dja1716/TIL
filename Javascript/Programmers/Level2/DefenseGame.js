function solution(n, k, enemy) {
  let map1 = new Map();
  var answer = 0;
  let max = -Infinity;
  let min = Infinity;
  let mapCount = 0;
  for (let i = 0; i < enemy.length; i++) {
    mapCount++;
    if (map1.has(enemy[i])) {
      map1.set(enemy[i], map1.get(enemy[i]) + 1);
    } else {
      map1.set(enemy[i], 1);
    }

    if (max < enemy[i]) {
      max = enemy[i];
    }
    if (min > enemy[i]) {
      min = enemy[i];
    }
    if (mapCount > k) {
      if (map1.get(min) === 1) {
        map1.delete(min);
        min = [...map1.keys()].reduce((prev, curr) => {
          if (curr < prev) return curr;
          return prev;
        }, 0);
      } else {
        map1.set(min, map1.get(min) - 1);
      }
      mapCount--;
    }

    if (n < enemy[i]) {
      if (k <= 0) break;
      k--;
      mapCount--;
      const tempMax = max;
      if (map1.get(max) === 1) {
        map1.delete(max);
        max = [...map1.keys()].reduce((prev, curr) => {
          if (curr > prev) return curr;
          return prev;
        }, 0);
      } else {
        map1.set(max, map1.get(max) - 1);
      }
      n += tempMax - enemy[i];
    } else {
      n -= enemy[i];
    }
    answer++;
  }
  return answer;
}


function solution2(n, k, enemy) {
    let [left, right] = [0, enemy.length];
    let mid = Math.floor((left + right) / 2);

    while (left <= right) {
        const round = enemy.slice(0, mid).sort((a, b) => b - a);
        let fever = k;
        const remain = round.reduce((acc, val) => {
            if (fever > 0) {
                fever--;
                return acc;
            } else return acc + val
        }, 0);
        // console.log(round, fever, remain, mid)
        if (n - remain >= 0) left = mid + 1;
        else right = mid - 1;
        mid = Math.floor((left + right) / 2);
    }

    return left - 1;
}
