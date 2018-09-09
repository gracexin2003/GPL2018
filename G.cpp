#include <iostream>
#include <vector>

using namespace std;

int main(int argc, const char * argv[]) {

    /*
    4 8
    0 0 0 0 0 0 0 0
    0 0 2 0 0 0 1 0 
    0 0 2 2 0 0 1 0 
    3 0 0 0 0 0 0 0
    */
  
    int numOfRows, numOfCol;
    cin >> numOfRows >> numOfCol;

    vector<vector<int> > grid;
    vector<vector<pair<int, int> > > pointsFort;

    for (int i = 0; i <= numOfRows*numOfCol; i++) {
        vector<pair<int, int> > tempTwo;
        pointsFort.push_back(tempTwo);
    }
    for (int i = 0; i < numOfRows; i++) {
        vector<int> temp (numOfCol, 0);
        grid.push_back(temp);
    }

    for (int i = 0; i < numOfRows; i++) {
        for (int j = 0; j < numOfCol; j++) {
            char tempCHar;
            cin >> tempCHar;
            grid[i][j] = (int) (tempCHar - '0');
            if (grid[i][j] > 0) {
                pointsFort[grid[i][j]].push_back(make_pair(i, j));
            }
        }
    }
    
    bool foundNum = true;
    double minP = 2^31-1, minA = 1;
    int IDNum = 0;
    
    for (int i = 1; i <=numOfRows*numOfCol; i++ ) {
        if (pointsFort[i].size() == 0) {
            break;
        }
        //for fort one
        double temppermSum = 0;
        for (int j = 0; j < pointsFort[i].size(); j++) {
            //for each pair
            int currX = pointsFort[i][j].first;
            int currY = pointsFort[i][j].second;
            int perm = 4;
            int sides = 0;
            if ((currX-1 > -1) and (grid[currX-1][currY] == i)) {
                perm--;
            }
            if ((currY-1 > -1) and (grid[currX][currY-1] == i)) {
                perm--;
            }
            if (!(currX+1 >= numOfRows) and (grid[currX+1][currY] == i)) {
                perm--;
            }
            if (!(currY+1 >= numOfCol) and (grid[currX][currY+1] == i)) {
                perm--;
            }
            temppermSum+=perm;
        }
        double area = pointsFort[i].size();
        
        if (((minP/minA) > (temppermSum/area))) {
            minP = temppermSum;
            minA = area;
            IDNum = i;
        }

    }

    cout <<IDNum << endl;
    return 0;

}