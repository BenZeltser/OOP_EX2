# **OOP 2021 - Ex2** 

## About
 A Third out of 6 Projects within the OOP Course Syllabus.
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

