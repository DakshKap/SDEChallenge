package main;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageArrayList implements MovingAverage{
	
	private List<Long> storage;
    private long sum;
    private int windowSize;
    private int windowStart;

    public MovingAverageArrayList(int windowSize) throws Exception {
        //To ensure that window size is always positive
        if(windowSize < 1 ){
            throw new Exception("N should always be a positive integer");
        }
        storage = new ArrayList<>();
        sum = 0;
        this.windowSize = windowSize;
        windowStart = 0;
    }

    /*Returns Moving average while ensuring if the number of elements in the list are less than the window size. It should only return the Average for those elements.
      For example: If the windows size is set to 10 but this method is called when the list contains only 5 elements. It will only return the average of the 5 elements in the list */
    @Override
    public double getAverage() {

        if (storage.isEmpty()) return 0;

        if(storage.size()<windowSize){
            return (double)sum / (double) storage.size();
        }

        return (double)sum / (double)windowSize;
    }

    /*This method adds element at the end of the list while keeping track of the Node from where the window starts.
      On addition of new element the the window start node is moved forward by one */
    @Override
    public void add(long value) {
        //Slide Average Window
        if(storage.size() < windowSize){
           windowStart = 0;
        }else{
            sum -= storage.get(windowStart);
            windowStart++;
        }

        //Add element to the list
        storage.add(value);
        sum += value;
    }

    @Override
    public long get(int index) { 
        return storage.get(index);
    }

    @Override
    public int getSize() {
        return storage.size();
    }

	
	
}
