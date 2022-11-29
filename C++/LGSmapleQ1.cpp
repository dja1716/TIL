// LG sample 1
#include <iostream>
#include <string>
#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> runnerV;
map<int, int> runnerM;


int main()
{
  cout << "start" << endl;

  int n,t;
  string line;
  getline (cin, line);
  n = stoi(line.substr(0, line.find(' ')));
  t = stoi(line.substr(line.find(' ')+1, line.length()));
  int p, s;
  for(int i = 0; i < n; i++) {
    getline(cin, line);
    p = stoi(line.substr(0, line.find(' ')));
    s = stoi(line.substr(line.find(' ')+1, line.length()));
    runnerM.emplace(make_pair(p, s));
  }

  
  
  
  int result = n;
  
  for(auto it = runnerM.begin(); it != runnerM.end(); it++) {
      auto jt = it;
      if(++jt != runnerM.end()) {
          if(it->first + it->second * t >= jt->first + jt->second * t) {
              result--;
          }
      }
  }

  cout << result << endl;
  return 0;
}
