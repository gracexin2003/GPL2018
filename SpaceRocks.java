package GPL2018;

public class SpaceRocks {

	int INV = 1<<29;
	int SIZE = 40; // 100000;
	int[] mDP = new int[SIZE];
	int mNumEng, mNumAst;
	int[][] mEng, mAst;
	int mRes;
	
	public static void main(String[] args) {
		SpaceRocks sr = new SpaceRocks();
		sr.test();
	}
	
	void test() {
		String[][] logList = {
				{"3 3", "3 1", "4 2", "6 5", "3 2", "7 1", "6 7"}};
		
		for (int i =0; i < logList.length; ++i) {
			proc(logList[i]);
		}
	}
	
	void proc(String[] logs) {
		String[] bufs;
		int cnt;
		
		bufs = logs[0].split(" ");
		mNumEng = Integer.parseInt(bufs[0]);
		mNumAst = Integer.parseInt(bufs[1]);
		
		mEng = new int[mNumEng][2];
		mAst = new int[mNumAst][2];
		
		for (int i = 0; i < mNumEng; ++i) {
			bufs = logs[i+1].split(" ");
			mEng[i][0] = Integer.parseInt(bufs[0]);
			mEng[i][1] = Integer.parseInt(bufs[1]);
			
			System.out.println("Engine: " + mEng[i][0] + " " + mEng[i][1]);
		}
		
		cnt = mNumEng + 1;
		for (int j = 0; j < mNumAst; ++j) {
			bufs = logs[cnt+j].split(" ");
			mAst[j][0] = Integer.parseInt(bufs[0]);
			mAst[j][1] = Integer.parseInt(bufs[1]);

			System.out.println("Asteroid: " + mAst[j][0] + " " + mAst[j][1]);
		}
		
		proc();
	}
	

	void proc() {
		for (int i = 0; i < SIZE; ++i) {
			mDP[i] = -INV;
		}
		
		for (int j = 0; j < mNumEng; ++j) {
			int w = mEng[j][0];
			int v = -mEng[j][1];
			
			if (w < 0 || w >= SIZE) {
				continue;
			}
			
			if (v > mDP[w]) mDP[w] = v;

			// Must in reverse order
			for (int k = SIZE-1; k >= 0; --k) {
				if (k == w) continue;
				if (mDP[k] == -INV) continue;
				
				int ww = w + k;
				int vv = v + mDP[k];
				
				if (ww < 0 || ww >= SIZE) {
					continue;
				}
				
				if (vv > mDP[ww]) {
					mDP[ww] = vv;
				}
			}
		}
		
		printDP();
		
		for (int j = 0; j < mNumAst; ++j) {
			int w = mAst[j][0];
			int v = mAst[j][1];
			
			if (w < 0 || w >= SIZE) {
				continue; 
			}

			// Engine's weight must be greater than or euqal to Asteroid's weight. So starting from element with the same weight.
			for (int k = w; k < SIZE; ++k) {
				if (mDP[k] == -INV) continue;
				
				int ww = k - w;
				int vv = v + mDP[k];
				
				if (ww < 0 || ww >= SIZE) {
					continue; 
				}

				if (vv > mDP[ww]) {
					mDP[ww] = vv;
				}
			}
		}
		
		printDP();
		
		// Found the maximum value
		mRes = mDP[0];
		for (int r = 1; r < SIZE; ++r) {
			if (mDP[r] > mRes) mRes = mDP[r];
		}
		
		System.out.println("=== RESULT: " + mRes);
	}
	
	void printDP() {
		System.out.println("\n");
		for (int i = 0; i < SIZE; ++i) {
			if (mDP[i] ==  -INV) System.out.print("X ");
			else                 System.out.print(mDP[i] + " ");
		}
		System.out.println("\n");
	}
}
