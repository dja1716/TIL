#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

string solution(string number, int k) {
    string answer = number;
    set<int> toBeRemoved;
    bool quit = false;
    for(int i = 1; i < number.size(); i++) {    
        for(int j = i - 1; j >= 0; j--) {
            if(number.at(i) > number.at(j)) {
                toBeRemoved.emplace(j);
                if(toBeRemoved.size() == k) {
                    quit = true;
                    break;
                }
            } else {
                break;
            }
        }    
        if(quit) break;
    }
    if(!quit) {
        int temp = k - toBeRemoved.size();
        for(int i = 0; i < temp; i++) {
            answer.pop_back();
        }
    }
    for(auto rit = toBeRemoved.rbegin(); rit != toBeRemoved.rend(); rit++) {
        answer.replace(*rit, 1, "");
    }
    return answer;
}
