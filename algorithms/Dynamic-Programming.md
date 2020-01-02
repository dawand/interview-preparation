## Dynamic-programming 
### Use cases
* When to use - optimize time complexity from O(n!,2^n) to O(n^2, n^3)
  - Calculate max or min
  - Calculate the number of solutions
  - Calculate whether it is true or not
* When not to use - optimize time complexity from O(n^3, n^2) further
  - Calculate concrete solutions themselves rather than just the number of solutions
  - Input is a collection rather than a sequence (e.g. Longest consecutive sequence)

### Problems to consider
* State: how to define dp[i] or dp[i][j]
* Induction rule: how to calculate big problems into smaller ones
* Initialization: starting point
* Answer: ending point

### Implementation methods: 
* Multi-loop: bottom-up approach
* Memorized search: top-down approach
* Use cases:
  - In most cases, both of them can be applied. Could start with bottom-up approach because it is usually more concise. 
  - But some times memorized search is more appropriate
    + When it is easier to start thinking from the last step rather than the first step. Example: Burst ballons, Stone-game (Leetcode)
    + When the induction rule is not sequential, thus hard to define.  Example: Longest increasing subsequences in 2D (Leetcode)
    + When the initialization state is hard to find. Example: Longest increasing subsequences in 2D (Leetcode)

### Memorization array tricks 
* For non grid-based dynamic programming problems, for N number/character, array of size N+1 is allocated. The position at 0 index is used for specially used for initialization.
* Rolling array
  - for 1D dp, e.g.
    + If induction rule is f[i] = max(f[i-1], f[i-2]) + A[i], namely f[i] only depends on f[i-1] and f[i-2]
    + To use rolling array, induction rule can be rewritten as f[i%2] = max(f[i-1]%2, f[i-2]%2)
  - for 2D dp, e.g.
    + if f[i][j] only depends on f[i][.], namely i th row only depends on i-1 th row
    + To use rolling array, induction rule can be rewritten as f[i%2][j] = f[(i-1)%2] row
  - procedures to use rolling array: write non-rolling version first, then write rolling version 

```java
// this code snippet demonstrate procedures to use rolling array
// 1D case
// first step: write a solution not based on rolling array
public int houseRobber( int[] A )
{
  int n = A.length;
  if ( n == 0 )
  {
    return 0;
  }
  long[] res = new long[n+1];

  res[0] = 0;
  res[1] = A[0];
  for ( int i = 2; i <= n; i++ )
  {
    res[i] = Math.max( res[i-1], res[i-2] + A[i-1]);
  }
  return res[n];
}
// second step: use mod % to transform solution to rolling array
// res[i] is  only related with res[i-1] and res[i-2], mod 2
public int houseRobber_RollingArray( int[] A )
{
  int n = A.length;
  if ( n == 0 )
  {
    return 0;
  }
  long[] res = new long[2];

  res[0] = 0;
  res[1] = A[0];
  for ( int i = 2; i <= n; i++ )
  {
    // key change here: %k, k is related with number of elements being relied on
    res[i%2] = Math.max( res[(i-1)%2], res[(i-2)%2] + A[i-1]);
  }
  return res[n];  
}
```

### Type
- Coordinate based 
  + Patterns:
    * state: f[x,y] represents goes to x,y position from starting point
    * induction rule: f[x,y] from f[x-1, y] or f[x, y-1]
    * initialization: f[0,0~width], f[0~height, 0]
    * answer: usually f[m,n]
  + Examples: Minimum Path Sum, Unique Path I�, Climbing stairs, Jump game I/II
- 1D sequence 
  + Patterns:
    * state: f[i] represents first i position, digits, characters
    * induction rule: f[i] from f[j], j < i
    * initialize: f[0] = 0, f[1]
    * answer: f[n]
  + Examples: Longest increasing subsequence, Word break I, House robber
- 2D sequences 
  + Patterns: 
    * state: f[i,j] represents the results of first i numbers/characters in sequence one matching the first j numbers/characters in sequence two
    * induction rule: how to decide f[i,j] from previous (varies a lot here)
    * initialize: f[0,i] and f[i,0]
    * answer: f[n,m]( n = s1.length(), m = s2.length() )
  + Examples: Edit distance, Regular expression matching, Longest common subsequences, Maximal rectangle/Square
- Range based 
  + Patterns:
    * state: f[i,j] represents whether the substring from i to j is a palindrome
    * induction rule: f[i,j] = f[i+1,j-1] && (s[i] == s[j])
    * initialize: f[i][i] = true, f[i][i+1] = s[i] == s[i+1]
    * answer: f[0,n]
  + Examples: Palindrome partition II, Coins in a line III (Leetcode), Stone game, Burst ballons, Scramble string 
- Game 
  + Patterns:
    * state: f[i] represents win/lose max/min profit for the first person
    * induction rule: avoid defining second person's state because second person always tries his best to defeat first person/make first person profit least.
    * initialize: varies with problem
    * answer: f[n]
  + Examples: Coin in a line (Leetcode), Coin in a line II (Leetcode), Flip game II
- Backpack 
  + Patterns:
    * state: f[i][S]: whether the first i items could form S/Max value/number of ways
    * induction rule: varies with problems
    * initialize: varies with problems
    * answer: varies with problems
  + Examples: Backpack I-VI (Leetcode), K Sum (Leetcode), Minimum adjustment cost (Leetcode)