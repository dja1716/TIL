#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;


int helper(int l, int i) {
    int result;
    switch(i) {
        case 0:
            result = ((((5 + 1) * 5 + 1) * 5 + 1) * 5 + 1) * l + 1;
            break;
        case 1:
            result = (((5 + 1) * 5 + 1) * 5 + 1) * l + 1;
            break;
        case 2:
            result = ((5 + 1) * 5 + 1) * l + 1;
            break;
        case 3:
            result = (5 + 1) * l + 1;
            break;
        case 4:
            result = 1 * l + 1;
            break;
    }
    return result;
}

// 1 * l + 1
// (5 + 1) * l + 1
// ((5 + 1) * 5 + 1) * l + 1
// (((5 + 1) * 5 + 1) * 5 + 1) * l + 1
// ((((5 + 1) * 5 + 1) * 5 + 1) * 5 + 1) * l + 1
int solution(string word) {
    int answer = 0;
    map<char, int> m;
    m.emplace('A', 0);
    m.emplace('E', 1);
    m.emplace('I', 2);
    m.emplace('O', 3);
    m.emplace('U', 4);
    
    for(int i = 0; i < word.length(); i++) {
        answer += helper(m.at(word[i]), i);
    }

    
    return answer;
}
