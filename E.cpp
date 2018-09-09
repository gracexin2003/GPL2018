#include <iostream>
#include <vector>

using namespace std;

int main(int argc, const char * argv[]) {
    // insert code here...
    
    /*
        7 4
     A 2 3
     A 5 7
     R 3 5
     A 4 5
     
     */
    
    int numOfPot, numOfIn;
    cin >> numOfPot >> numOfIn;
    
    int potatoes[numOfPot+1];
    for (int i = 0; i <=numOfPot; i++) {
        potatoes[i] = 0;
    }
    
    for (int i = 0; i < numOfIn; i++) {
        char Name;
        cin >> Name;
        if (Name == 'A') {
            //plant
            int startNum, endNum;
            cin >> startNum >> endNum;
            for(int j= startNum; j <=endNum; j++) {
                potatoes[j] = 1;
            }
        } else if (Name == 'R') {
            //destroy
            int startNum, endNum;
            cin >> startNum >> endNum;
            for(int j= startNum; j <=endNum; j++) {
                if (j > numOfPot) {
                    continue;
                }
                potatoes[j] = 0;
            }
        }
    }

    int plantPot = 0;
    for (int i = 1; i <= numOfPot; i++) {
        if (potatoes[i] == 1) {
            plantPot++;
        }
    }
    cout << plantPot << endl;