package com.dimsum.livewallpaperclock;

import android.util.Log;

public class PriorityQueue {
	
	private final int MAX_SIZE;
	private int[ ] array;
    private static final int ROOT = 0;
    private int lastIndex = ROOT;
    
	public PriorityQueue(int size) {
		MAX_SIZE= size;
		setArray(new int[MAX_SIZE]);
		java.util.Arrays.fill(getArray(), -1);
	}
	
	public void insert(int element) {
		if (lastIndex == MAX_SIZE) {
			return;
		}
		int elementIndex = lastIndex++;
		getArray()[elementIndex] = element;
		
		while (elementIndex != 0 && getArray()[elementIndex] < getArray()[parent(elementIndex)]) {
			swap(elementIndex, parent(elementIndex));
			elementIndex = parent(elementIndex);
		}
	}
	
	private int parent(int x) {
		return ((x + (x & 1)) / 2) - 1;
	}

	private int rightChildOf(int x) {
		return (x + 1) * 2;
	}
	
	private void swap(int a, int b) {
		int placeholder = getArray()[a];
		getArray()[a] = getArray()[b];
		getArray()[b] = placeholder;		
	}

	private int[ ] getArray() {
		return array;
	}

	private void setArray(int[ ] array) {
		this.array = array;
	}
	
	@Override 
	public String toString() {
		String description = "";
		for (int i = 0; i < getArray().length; i++) {
			Log.v("ME", String.format("Index: %d, %s", i, getArray()[i]));
		}
		return description;
	}
}
