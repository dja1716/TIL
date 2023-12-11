#include <string>
#include <vector>
#include <bits/stdc++.h>
 

using namespace std;


int helper(int w1, int w2, map<int, vector<int>> m) {
    int result = 0;
    queue<int> q;
    //
    vector<bool> notVisited(m.size(), true);
    if(w1 != 1) {
        q.push(1);
        result++;
        notVisited.at(0) = false;
    } else if(w2 != 2) {
        q.push(2);
        result++;
        notVisited.at(1) = false;
    } else {
        q.push(3);
        result++;
        notVisited.at(2) = false;
    }
    
     while(!q.empty()) {
        int temp = q.front();
         q.pop();
         for(int i = 0; i < m.at(temp).size(); i++) {
             int temp2 = m.at(temp).at(i);
             if((temp == w1 || temp == w2) && (temp2 == w1 || temp2 == w2)) {
                 continue;
             }
             if(notVisited.at(temp2 - 1)) {
                 notVisited.at(temp2 - 1) = false;
                 result++;
                 q.push(temp2);
             }
         }
     }
    if(result * 2 > m.size()) {
        result = result * 2 - m.size();
    } else {
        result = m.size() - result * 2;
    }
    cout << result;
    return result;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = INT_MAX;
    map<int, vector<int>> m;
    
    for(int i = 0; i < wires.size(); i++) {
        if(m.find(wires.at(i).at(0)) == m.end()) {
            vector<int> temp;
            temp.emplace_back(wires.at(i).at(1));
            m.emplace(make_pair(wires.at(i).at(0), temp));
        } else {
            m.at(wires.at(i).at(0)).emplace_back(wires.at(i).at(1));
        }
        
        if(m.find(wires.at(i).at(1)) == m.end()) {
            vector<int> temp;
            temp.emplace_back(wires.at(i).at(0));
            m.emplace(make_pair(wires.at(i).at(1), temp));
        } else {
            m.at(wires.at(i).at(1)).emplace_back(wires.at(i).at(0));
        }
    }
    
    for(int i = 0; i < wires.size(); i++) {
        int temp = helper(wires.at(i).at(0), wires.at(i).at(1), m);
        if(answer > temp) {
            answer = temp;
        }
    }
    
    return answer;
}
