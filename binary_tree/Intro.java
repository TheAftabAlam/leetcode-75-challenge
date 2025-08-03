🧠 Binary Tree Interview Notes
🌳 1. Basic Terminology
Node: A basic unit with a value and pointers to children.

Root: Topmost node in the tree.

Leaf: A node with no children.

Depth: Distance from the root to the node.

Height: Max depth from node to a leaf.

Subtree: A tree formed from any node and its descendants.

🏗️ 2. Types of Binary Trees
Type	Description
Full	Every node has 0 or 2 children
Perfect	All internal nodes have 2 children and all leaves at the same level
Complete	All levels are filled except possibly the last, which is filled left to right
Balanced	Height difference between left and right subtrees is ≤ 1
Binary Search Tree (BST)	Left subtree < root < right subtree

✨ 3. Traversal Techniques
Depth-First Traversal
Type	Order
In-order	Left → Root → Right
Pre-order	Root → Left → Right
Post-order	Left → Right → Root

Breadth-First Traversal
Level-order: Use a queue.

