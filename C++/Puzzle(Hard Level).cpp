#include <string>
#include <vector>
#include <bits/stdc++.h>

using namespace std;


typedef pair<int, int> pos;


queue<pos> helper1(vector<vector<int>> &table, int x, int y) {
    queue<pos> q;
    queue<pos> result;
    int size = table.size();
    q.push(make_pair(0, 0));
    while(!q.empty()) {
        pos p = q.front();
        q.pop();
        result.push(p);
        int posX = p.first;
        int posY = p.second;
        table.at(posX + x).at(posY + y) = 0;
        if(posX + 1 + x < size && table.at(posX + 1 + x).at(posY + y) == 1) {
            q.push(make_pair(posX + 1, posY));
            table.at(posX + x + 1).at(posY + y) = 0;
        }
        if(posX - 1 + x >= 0 && table.at(posX - 1 + x).at(posY + y) == 1) {
            q.push(make_pair(posX - 1, posY));
            table.at(posX + x - 1).at(posY + y) = 0;
        }
        if(posY - 1 + y >= 0 && table.at(posX + x).at(posY - 1 + y) == 1) {
            q.push(make_pair(posX, posY - 1));
            table.at(posX + x).at(posY + y - 1) = 0;
        }
        if(posY + 1 + y< size && table.at(posX + x).at(posY + y + 1) == 1) {
            q.push(make_pair(posX, posY + 1));
            table.at(posX + x).at(posY + y + 1) = 0;
        }
    }
    
    return result;
}



void helper2(vector<vector<int>> & game_board, queue<pos> q, int x, int y, bool b) {
    if(b) {
        while(!q.empty()) {
            pos p = q.front();
            q.pop();
            game_board.at(x + p.first).at(y + p.second) = 1;
        }
    } else {
        while(!q.empty()) {
            pos p = q.front();
            q.pop();
            game_board.at(x + p.first).at(y + p.second) = 0;
        }
    }
}

bool helper3(vector<vector<int>> game_board, int x, int y, queue<pos> q) {
    int size = game_board.size();
    queue<pos> tempQ = q;
    while(!q.empty()) {
        pos p = q.front();
        q.pop();
        if(p.first + x < 0 || p.second + y < 0 || p.first + x >= size || p.second + y >= size || game_board.at(p.first + x).at(p.second + y) == 1) {
            return false;
        } else {
            game_board.at(p.first + x).at(p.second + y) = 1;
        }
        
    }
    
    while(!tempQ.empty()) {
        pos p = tempQ.front();
        tempQ.pop();
        if(p.first + x - 1 >= 0 && game_board.at(p.first + x - 1).at(p.second + y) == 0) {
            return false;
        }
        if(p.second + y - 1 >= 0 && game_board.at(p.first + x).at(p.second + y - 1) == 0) {
            return false;
        }
        if(p.first + x + 1 < size && game_board.at(p.first + x + 1).at(p.second + y) == 0) {
            return false;
        }
        if(p.second + y + 1 < size && game_board.at(p.first + x).at(p.second + y + 1) == 0) {
            return false;
        }
    }
    return true;
}

bool helper4(vector<vector<int>> & game_board, queue<pos> q) {
    int size = game_board.size();
    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            if(game_board.at(i).at(j) == 0) {
                if(helper3(game_board, i, j, q)) {
                    helper2(game_board, q, i, j, true);
                    return true;
                }
            }
        }
    }
    return false;
}

 queue<pos> helper4Dir(queue<pos> q, int dir) {
     queue<pos> newQ;
     while(!q.empty()) {
         pos p = q.front();
         q.pop();
         if(dir == 0) {
             newQ.push(make_pair(p.first, p.second));
         } else if(dir == 1) {
             newQ.push(make_pair(-p.second, p.first));
         } else if(dir == 2) {
             newQ.push(make_pair(-p.first, -p.second));
         } else if(dir == 3) {
             newQ.push(make_pair(p.second, -p.first));
         }
     }
     return newQ;
 }

// 4 iterations
int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    int answer = 0;
    int size = table.size();
    for(int i = 0; i < size; i++) {
        for(int j = 0; j < size; j++) {
            if(table.at(i).at(j) == 1) {
                queue<pos> piece = helper1(table, i, j);
                bool temp = false;
                for(int k = 0; k < 4; k++) {
                    queue<pos> newQ = helper4Dir(piece, k);
                    if(helper4(game_board, newQ)) {
                        answer += piece.size();
                        break;
                    }
                }
            }
        }
    }

    return answer;
}
