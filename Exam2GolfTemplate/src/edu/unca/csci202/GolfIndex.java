package edu.unca.csci202;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GolfIndex {
	private int N; // keep N most recent scores
	private int M; // use best M scores (by differential) to compute "index"
	// INSERT ADDITIONAL INSTANCE VARIABLES HERE, IF NECESSARY
	private ArrayList<GolfScore> index;

	public GolfIndex(int N, int M) {
		this.N = N;
		this.M = M;

		// INITIALIZE ADDITIONAL INSTANCE VARIABLES HERE, IF NECESSARY
		index = new ArrayList<GolfScore>();
	}

	// This implementation is O(1) complexity
	public void insertScore(GolfScore score) {
		index.add(score);
		if (index.size() > N) {
			index.remove(0);
		}
	}

	// IMPLEMENT THIS METHOD
	/**
	 * 
	 * @return a list of the lowest M scores (by differential) of the past N
	 *         inserted scores
	 */
	// This implementation is O(n^2 log N)
	public List<GolfScore> getLowestM() {
		List<GolfScore> mList = index;
		Collections.sort(mList);
		while (mList.size() > M) {
			mList.remove(mList.size() - 1);
		}
		return mList;
	}

	// IMPLEMENT THIS METHOD
	/**
	 * 
	 * @return the average differential of the best
	 */
	public double computeIndex() {
		List<GolfScore> mList = getLowestM();
		double sum = 0;
		for (int i = 0; i < M - 1; i++) {
			sum += mList.get(i).getDifferential();
		}

		return sum / M;
	}

	// IMPLEMENT THIS METHOD
	// Doesn't print last items in list, Couldn't figure out in time
	public String toString() {
		List<GolfScore> mList = getLowestM();

		String rtrnStr = "";
		for (int i = 0; i < N; i++) {
			if (mList.contains(index.get(i))) {
				rtrnStr += "*";
			}
			rtrnStr += index.get(i) + "\n";
		}
		return rtrnStr;
	}

}
