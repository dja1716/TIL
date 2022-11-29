#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int answer = 0;
    int max = 0;
    int min = 0;
    for(int i = 0; i < sizes.size(); i++) {
        if(sizes.at(i).at(0) > sizes.at(i).at(1)) {
            if(max < sizes.at(i).at(0)) {
                max = sizes.at(i).at(0);
            }
            if(min < sizes.at(i).at(1)) {
                min = sizes.at(i).at(1);
            }
        } else {
            if(max < sizes.at(i).at(1)) {
                max = sizes.at(i).at(1);
            }
            if(min < sizes.at(i).at(0)) {
                min = sizes.at(i).at(0);
            }
        }
    }
    answer = max * min;
    return answer;
}
