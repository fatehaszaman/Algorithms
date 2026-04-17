# Algorithms

Java implementations of core algorithms from a Design and Analysis of Algorithms course. Covers graph algorithms, greedy methods, dynamic programming, and a detailed progression through sorting.

## Contents

| Directory | What's in it |
|---|---|
| `astar` | A* search, greedy best-first, uniform cost |
| `changeMaking` | Change-making problem — greedy vs. dynamic programming |
| `dijkstra` | Dijkstra's shortest path with interface abstraction |
| `divideConquer` | Divide and conquer problems |
| `graph` | Graph data structure with BFS/DFS traversal |
| `huffman` | Huffman encoding/decoding with priority queue |
| `mst` | Minimum spanning tree — Kruskal and Prim |

### Sorting — three folders, three stages

The sorting implementations are split intentionally across three folders representing different stages of the course:

- **`sorting.algorithms/`** — clean baseline implementations of Bubble, Heap, Quicksort (Hoare + Lomuto), Insertion, Selection, with a shared `Sort` base class
- **`sortingcomplexity/`** — the same algorithms instrumented with operation counters to empirically measure and compare time complexity; adds `MergeSort` and `OptimizedBubbleSort`; `TestBench` runs all of them and reports exact operation counts
- **`sorting/generics/`** — refactored to use Java generics and a Comparator-style `ISortingOrder` interface so the same sort works on any `Comparable` type in ascending or descending order

## Stack

Java
