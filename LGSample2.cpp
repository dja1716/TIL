// LG Sample 2


// LG Sample 2
#include <iostream>
#include <string>
#include <bits/stdc++.h>
using namespace std;


// 0 not selected
// 1 add
// -1 subtract
vector<pair<int, int>> v;



// from second iteration+
// end is not inclusive
void createTreeLeft(int end) {
    int smallPos = -1;
    int bigPos = -1;
    
    for(int i = end; i > 0; i--) {
        if(v.at(i).first < v.at(i-1).first) {
            smallPos = i;
            break;
        }
    }
    
    for(int i = smallPos - 1; i > 0; i--) {
        if(v.at(i).first > v.at(i-1).first) {
            bigPos = i;
            break;
        }
    }
    if(smallPos != -1 && smallPos != 0) {
        v.at(smallPos).second = -1;
        if(bigPos != -1) {
            v.at(bigPos).second = 1;
            createTreeLeft(bigPos-1);
        } else {
            v.at(0).second = 1;
        }
    }

}

// from second iteration+
// end is not inclusive
void createTreeRight(int start) {
    int smallPos = -1;
    int bigPos = -1;
    for(int i = start; i < v.size() - 1; i++) {

        if(v.at(i).first < v.at(i+1).first) {
            smallPos = i;
            break;
        }
    }
    
    for(int i = smallPos + 1; i < v.size() - 1; i++) {
        if(v.at(i).first > v.at(i+1).first) {
            bigPos = i;
            break;
        }
    }
    if(smallPos != -1 && smallPos != v.size()) {
        v.at(smallPos).second = -1;
        if(bigPos != -1) {
            v.at(bigPos).second = 1;
            createTreeRight(bigPos+1);
        } else {
            v.back().second = 1;
        }
    }
    
    
}


void solution() {
    int max = -1;
    int maxPos = -1;
    for(int i = 0; i < v.size(); i++) {
        if(v.at(i).first >= max) {
            max = v.at(i).first;
            maxPos = i;
        }
    }
    v.at(maxPos).second = 1;
    createTreeRight(maxPos+1);
    createTreeLeft(maxPos-1);
}


int main()
{
  int result = 0;
  int n;
  cout << "start" << endl;
  string line;
  getline (cin, line);
  n = stoi(line);
  for(int i = 0; i < n; i++) {
    int temp;
    cin >> temp;
   v.emplace_back(make_pair(temp, 0));
  }
  solution();
//   for(int i = 0; i < n; i++) {
//       cout << v.at(i).first << v.at(i).second << endl;
//       result += v.at(i).first * v.at(i).second;
//   }
  cout << "result: " << result << endl;

  return 0;
}
