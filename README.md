# Algorithms

Java implementations from a Design and Analysis of Algorithms course. The bulk of this is graph algorithms and sorting, which ended up being the most interesting parts of the course by a wide margin.

## Contents

| Directory | What's in it |
|---|---|
| `astar` | A* search, greedy best-first, uniform cost |
| `changeMaking` | Change-making problem: greedy vs. dynamic programming |
| `dijkstra` | Dijkstra's shortest path with interface abstraction |
| `divideConquer` | Divide and conquer problems |
| `graph` | Graph data structure with BFS/DFS traversal |
| `huffman` | Huffman encoding/decoding with priority queue |
| `mst` | Minimum spanning tree: Kruskal and Prim |

## Sorting: three folders, three stages

The sorting code is split across three folders on purpose. They represent three different passes at the same set of algorithms over the course of the semester.

`sorting.algorithms/` is the clean baseline: Bubble, Heap, Quicksort (Hoare and Lomuto variants), Insertion, Selection. All extend a shared `Sort` base class with a static `swap` utility.

`sortingcomplexity/` instruments the same algorithms with operation counters so you can run them and see the actual step counts, not just the asymptotic labels. `TestBench` runs all of them on the same input and prints a comparison. This is also where `MergeSort` and `OptimizedBubbleSort` were added.

`sorting/generics/` is a refactor using Java generics and a Comparator-style `ISortingOrder` interface. The same sort logic works on any `Comparable` type in either ascending or descending order. There is also a generic `Stack` implementation used internally.

## Stack

Java
