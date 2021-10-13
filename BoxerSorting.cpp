#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;

struct Boxer {
    float winRate;
    int winFromHeavies;
    int weight;
    int number;
    
};


vector<int> solution(vector<int> weights, vector<string> head2head) {
    vector<int> answer;
    vector<Boxer> vb;
    
    for(int i =0; i < weights.size(); i++) {
        Boxer tempBoxer;
        int totalFight = 0;
        int totalWin = 0;
        int weight = weights.at(i);
        int totalWinFromHeavies = 0;
        int myNumber = i;
        for(int j = 0; j < weights.size(); j++) {
            char tempChar = head2head.at(i).at(j);
            if(tempChar != 'N') {
                totalFight++;
                if(tempChar == 'W') {
                    totalWin++;
                    if(weights.at(j) > weight) {
                        totalWinFromHeavies++;
                    }
                }
            }
        }
        if(totalFight == 0) {
            tempBoxer.winRate = 0;
        } else {
            tempBoxer.winRate = totalWin / totalFight; 
        }
        tempBoxer.winFromHeavies = totalWinFromHeavies;
        tempBoxer.weight = weight;
        tempBoxer.number = myNumber;
        vb.emplace_back(tempBoxer);
    }
    int minIndex;
    Boxer tempBoxer;
    for(int i = 0; i < vb.size() - 1; i++) {
        minIndex = i;
        for(int j = i + 1; j < vb.size(); j++) {
            if(vb.at(j).winRate > vb.at(i).winRate) {
                minIndex = j;
            } else if(vb.at(j).winRate == vb.at(i).winRate) {
                if(vb.at(j).winFromHeavies > vb.at(i).winFromHeavies) {
                    minIndex = j; 
                } else if(vb.at(j).winFromHeavies == vb.at(i).winFromHeavies) {
                    if(vb.at(j).weight > vb.at(i).weight) {
                        minIndex = j;
                    } else if(vb.at(j).weight == vb.at(i).weight) {
                        if(vb.at(j).number < vb.at(i).number) {
                            minIndex = j;
                        }
                    }
                }
            }
        }
        if(minIndex != i) {
            tempBoxer = vb.at(minIndex);
            vb.at(minIndex) = vb.at(i);
            vb.at(i) = tempBoxer;
        }
    }
    for(int i = 0; i < vb.size(); i++) {
        answer.emplace_back(vb.at(i).number + 1);
    }
    return answer;
}
