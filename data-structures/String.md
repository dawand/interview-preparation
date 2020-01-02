## String 
### Why String is immutable or final 
* By design: 
  - **String pool**: Strings are cached in String pool and shared between multiple clients. 
  - **Security**: No one could override the behavior of String class and don't need to worry about many security threats.
  - **Performance**: Cache its hashcode. Avoid synchronization.

### String vs StringBuilder vs StringBuffer 

| Comparison | String         | StringBuilder | StringBuffer  |
| --------------------- |:-------------:| -----:|-----:|
| Storage area  | Constant string pool    | Heap | Heap |
| Modifiable    | Immutable     |   Mutable | Mutable |
| Thread safe   | Yes     |   No | Yes | 
| Performance   | Fast    |   Fast | very slow| 

### Word reverse 



### Palindrome 
* Several ways to solve the Longest palindrome substring problem
  - DP-based solution: O(n^2) space and time, if need to storing palindrome result, this is always better (e.g. palindrome partitioning)
  - Start looping from middle: O(n^2) time
  - Manacher's algorithm: O(n) time, not generic enough.
