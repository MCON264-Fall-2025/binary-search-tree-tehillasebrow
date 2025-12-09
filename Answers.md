# BST Traversal Answers

## Why does inorder traversal of a BST return elements in sorted order?

In a Binary Search Tree (BST), every node follows a strict rule: all values in the left subtree are **less than** the node’s value, and all values in the right subtree are **greater than** the node’s value.

Inorder traversal visits nodes in this order:

1. Left subtree
2. Current node
3. Right subtree

By the time you visit a node, you have already visited **all smaller values** (left subtree). After visiting it, you then visit **all larger values** (right subtree). Repeating this rule recursively for every node naturally produces the values in increasing (sorted) order.

---

## Example of an insertion order that produces a highly unbalanced BST

A highly unbalanced BST occurs when values are inserted in **already sorted order**.

**Example insertion order:**

```
1, 2, 3, 4, 5
```

This creates a tree that looks like a linked list leaning to the right:

```
1
 \
  2
   \
    3
     \
      4
       \
        5
```

### Inorder traversal of this tree

Even though the tree is unbalanced, the inorder traversal is still:

```
1, 2, 3, 4, 5
```

This shows that inorder traversal always produces sorted output **regardless of tree shape**, as long as the BST property is maintained.

---

## Differences Explained

### Recursive vs Iterative Traversal

**Recursive traversal** uses the call stack implicitly. Each recursive call handles a subtree, which makes the code shorter and easier to understand. However, it risks stack overflow if the tree is very deep or unbalanced.

**Iterative traversal** uses an explicit data structure (like a stack or queue) to manage traversal. It avoids deep recursion and gives more control over memory, but the code is usually more verbose and harder to read.

---

### Depth-First vs Breadth-First Traversal

**Depth-first traversal (DFS)** explores as far down a branch as possible before backtracking. In trees, this includes preorder, inorder, and postorder traversals. DFS is memory-efficient and works well when you need to process entire paths or subtrees.

**Breadth-first traversal (BFS)** visits nodes level by level, from top to bottom and left to right. It uses a queue and is useful when the position (level) of a node matters.

---

## When might you prefer breadth-first traversal in a real application?

Breadth-first traversal is preferred when:

* You need to find the **shortest path** or minimum number of steps (e.g., in routing or social networks)
* You want to process data **level by level**, such as displaying a hierarchy
* You are searching for the **closest matching node** to the root

In these situations, BFS can find results faster than DFS because it examines nodes in increasing order of depth rather than diving deep into one branch.
