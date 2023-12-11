#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

vector<string> solution(vector<vector<int>> line) {
    vector<string> answer;
    vector<pair<long long, long long>> starPos;
    long long xMin = LLONG_MAX;
    long long yMin = LLONG_MAX;
    long long xMax = LLONG_MIN;
    long long yMax = LLONG_MIN;
    
    
    for(int i = 0; i < line.size() - 1; i++) {
        for(int j = i + 1; j < line.size();j++) {
            long long A = line.at(i).at(0);
            long long B = line.at(i).at(1);
            long long E = line.at(i).at(2);
            long long C = line.at(j).at(0);
            long long D = line.at(j).at(1);
            long long F = line.at(j).at(2);
            
            long long bottom = A * D - B * C;
            if(bottom == 0 || (B * F - E * D) % bottom != 0 || (E * C - A * F) % bottom != 0) {
                continue;
            }
            long long x = (B * F - E * D) / bottom;
            long long y = (E * C - A * F) / bottom;
            
            starPos.emplace_back(make_pair(x, y));
            
            if(x < xMin) {
                xMin = x;
            }
            
            if(x > xMax) {
                xMax = x;
            }
            
            if(y < yMin) {
                yMin = y;
            }
            
            if(y > yMax) {
                yMax = y;
            }
        }
    }
    long long rowSize = xMax - xMin + 1;
    long long columnSize = yMax - yMin + 1;
    // cout << rowSize;
    // cout << columnSize << endl;
    // for(int i = 0; i < starPos.size(); i++) {
    //     cout << starPos.at(i).first << " " << starPos.at(i).second << endl;
    // }
    string temp;
    for(int j = 0; j < rowSize; j++) {
        temp.push_back('.');
    }
    for(int i = 0; i < columnSize; i++) {
        
        answer.emplace_back(temp);
    }
    
    for(int i = 0; i < starPos.size(); i++) {
        answer.at(yMax - starPos.at(i).second).at(xMax - starPos.at(i).first) = '*';
    }
    
    return answer;
}
