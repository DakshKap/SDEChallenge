# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.

## Coding Solution

### Intiution

The intution behind the solution was to solve using a sliding window approach. Data structure keeps track of last N elements added to the data structure using a sliding window. The element is added to the end of the list. This approcah allows us to access the moving average in constant time.

To support the above approach and be able to have access to the elements list based structure is feasible.

I have created 2 implementation for the above problem, one using a custom Linked List and another using ArrayList.

Both the implementations provide you with follwoing methods:

getAverage() - Returns the moving average as a double value.

add(long value) - Adds element at the end of the list.

get(int index) - Returns the element at that index as a long value.

getSize(int index) - Returns size of the list as an int value.

There are some trade offs between the two implemetations which is explained below.

### ArrayList Implementation (/SDEChallenge/src/main/MovingAverageArrayList.java)

- Get is always done in constant time.
  Time Complexity: O(1).
- Addition is done in constant mostly but in worst case is done in linear time because array needs to be resized and copied.
  Time Complexity: O(1) amortized, O(n) worst case.
- Get Moving Average  is always done in constant time.
  Time Complexity: O(1).

### LinkedList Implementation (/SDEChallenge/src/main/MovingAverageLinkedList.java)

- Get is always done in linear time.
  Time Complexity: O(n).
- Addition is always done in constant time.
  Time Complexity: O(1).
- Get Moving Average  is always done in constant time.
  Time Complexity: O(1).

### Further Enhancements

Currently the data structure only allows us to add elements at the end of the list. If we wish to add elements at specific indexes we can maintain the sliding window using additional storage which would be a Queue.

## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.

## Design Solution
GA like Analytics System.pdf (Design Solution/GA like Analytics System.pdf)
