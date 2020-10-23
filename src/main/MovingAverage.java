package main;

public interface MovingAverage {

	 //Returns average of last N elements, N is set while intializing the data structure
    public double getAverage();

    //adds at the end of the list
    public void add(long value);

    //get element at an index
    public long get(int index);

    //returns size of the list
    public int getSize();

}
