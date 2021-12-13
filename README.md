# **OOP 2021 - Ex2** 

## About
 A Third out of 6 Projects within the OOP Course Syllabus in Ariel University, Computer Science Department.
 On this Project, We are dealing with Graphs. Directed Graphs with Weighed Edges to be precised.
 The Program will preform a variety of different Operations which is exapanded in the following:
 We Wrote a Program with the following features:

## Features

#### :one: **Is Conncted - Determine if a Directed Graphs with Weighed Edges is Connected**

#### :two: Shortest Path - Find the Shortest Path between any Source Node and any Destination Node within the Graph - Based on Dijkstra shortest path algorithm _[More info](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm)_

#### :three: **Within the Graph, Find the Node which minimizes the maximum distance to all the other nodes. Assuming the graph is Connected.  _[More info](https://en.wikipedia.org/wiki/Graph_center)_**

#### :four: TSP (Travelling Salesman problem) - Within the Graph, The algorithm computes a list of consecutive nodes which go over all the nodes in cities. (In this Problem, the Nodes of the graph represent the cities, and the Edges present the Roads between them) _[More info](https://en.wikipedia.org/wiki/Travelling_salesman_problem)_

#### :five: :iphone: Graphical User Interface - an interactive user-Friendly Interface that allows the user to easily activate the different features within the program - Using Java Swing Library.

#### :six: :iphone: Visual presentation - A (X,Y) Coordinates based Grid with a Scaled Visual Presentation of the Graph - Using Graphics2D Library.

## Program Classes and Interfaces 

#### :red_circle: Mention worthy:

##### the DWG (Directed Weight Graph) class holds two [Hash maps](https://en.wikipedia.org/wiki/Hash_table): One Hashmap (named nodes) is mapping indecies to Nodes. the Second  Hashmap (named AdjList) is mapping between a group of nodes to a group of multiple [Arraylist](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html) instances, each is holding the Edges of the node accordingly.

Within this Section, a Plan for the different Classes, And how they interact, is described using a UML Diagram:

![UML](https://user-images.githubusercontent.com/92685838/145684649-a00666f6-cbca-47cd-8ee4-ff39f818f7b7.png)

## Tests
 
 In this section, We elaborate on the different tests that will assure the program will run properly and will handle possible hurdles.
 
 - **Valid input** Make sure the a vaild input hsa been inserted through the Json file - Handle with Exception 
 
 - **Null inputs** Make Sure Json file is not empty. if so, Handle with [NullPointerException](https://www.geeksforgeeks.org/null-pointer-exception-in-java/)
 
 - **Iterators** - Make Sure Nodes added to the graph are only done while *NO ITERATOR IS RUNNING* if so, Throw an Exception.
 
 - **Infinite loops** - due to multiple long running Loops inside the program that aren't dependent on fixed Values, Avoid infinite Loops by the usage of throwing 
 [StackOverFlow](https://www.geeksforgeeks.org/stackoverflowerror-in-java-with-examples/) Exception.
 
 - **Preformance** - Make sure the runtime does not exceed the rational Expectation for the program (e.g Hours, Days, Not responding ETC...)

- **Gui** - Make sure Gui does not crush during run time if given bad input. make sure Gui is running Properly.

- **Unit Testing** - In general, we use [Junit](https://en.wikipedia.org/wiki/JUnit) to Test the Units of code that we write inside the Project.

- **Algorithms** - Make sure Algorithms run properly, review the code and also be certified that the [Time Complexity](https://en.wikipedia.org/wiki/Time_complexity) is Optimal.

- **Integration** - Make sure the multiple Classes with the Project work together properly, using by-hand testing, assuring that the program is running properly with its various edge cases.

## Preformance
# G1
- **GUI** - It takes 38 millisecods to load the Graph in the GUI.
- **Save**- It takes 43 millisecods to save a graph into a JSON file.
- **isConnected** It takes 0 milliseconds to execute the algorithm.
**shorestPathDist** It tkes 0 millisecond to execute the algorithm.
- **shortestPath** It takes 2 milliseconds to execute the algorithm.
- **center** It takes 1 milliseconds to execute the algorithm.
- **tsp** It takes 3 milliseconds to execute the algorithm.
 
# G2

- **GUI** - It takes 38 millisecods to load the Graph in the GUI.
- **Save**- It takes 37 millisecods to save a graph into a JSON file.
- **isConnected** It takes 0 milliseconds to execute the algorithm.
- **shorestPathDist** It tkes 0 millisecond to execute the algorithm.
- **shortestPath** It takes 2 milliseconds to execute the algorithm.
- **center** It takes 2 milliseconds to execute the algorithm.
- **tsp** It takes 2 milliseconds to execute the algorithm.
# G3
- **GUI** - It takes 40 millisecods to load the Graph in the GUI.
- **Save**- It takes 44 millisecods to save a graph into a JSON file.
- **isConnected** It takes 0 milliseconds to execute the algorithm.
- **shorestPathDist** It tkes 1 millisecond to execute the algorithm.
- **shortestPath** It takes 2 milliseconds to execute the algorithm.
- **center** It takes 1 milliseconds to execute the algorithm.
- **tsp** It takes 3 milliseconds to execute the algorithm.
# 1000Nodes
- **GUI** - It takes 39 millisecods to load the Graph in the GUI.
- **Save**- It takes 152 millisecods to save a graph into a JSON file.
- **shorestPathDist** It tkes 4 millisecond to execute the algorithm.
- **center** It takes 2 milliseconds to execute the algorithm.
#10000Nodes
- **GUI** - It takes 39 millisecods to load the Graph in the GUI.
- **Save**- It takes 148 millisecods to save a graph into a JSON file.
- - **shorestPathDist** It tkes 25 millisecond to execute the algorithm.
- **shortestPath** It takes 23 milliseconds to execute the algorithm.
- **center** It takes 2 milliseconds to execute the algorithm.
#100000Nodes
- **GUI** - It takes 41 millisecods to load the Graph in the GUI.
- **Save**- It takes 140 millisecods to save a graph into a JSON file.
- **center** It takes 1 milliseconds to execute the algorithm.


## User Instructions
 
as the Exectuable file is running, two Windows will open: 

#### GUI Window - a Graphic User Interface with a menu bar that offers user interaction with the vraious functinalities 
The GUI is very staright forward. every Button is self explanatory and the interaction is very intuitive. 

with a press of a Button, a new Text field will be Poped up. which will contain a Button and an Insertion field. 

The insertion field allows the user to insert Information that manipulates the output. 

within every insertion field, The Button alludes plain instructions on the insertion Formatting.

#### Grid Window - a [Scaled]([https://en.wikipedia.org/wiki/Scale_(ratio) Plane that presents the Graph with it's Nodes, Edges and (x,y) Coordinates 

The Scaled Graph will be appeard in coherence with the Given Graph.

Download Link: https://file.io/nAUs5yis9SB0




