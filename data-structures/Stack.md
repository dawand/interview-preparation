## Stack 
### Calculator 
* Evaluate infix expression. The problem can have various follow-ups
  - How to define input: String s or String[] tokens. If input is defined as String s and numbers might include negative numbers, then parsing negative numbers can be kind of cumbersome. When possible, define input as String[] tokens. Even when required to define input as String s, double check whether we need to deal with negative numbers.
  - Whether contain space
  - Whether need to deal with parentheses
```java
    public int calculate( String s )
    {
      // assertions on validity
      
      Stack<Integer> valStack = new Stack<>();
      Stack<Character> opStack = new Stack<>();
      for ( int i = 0; i < s.length( ); i++ )
      {
        char token = s.charAt( i );
        if ( token == ' ' )
        {
          continue;
        }
        else if ( token == '(' )
        {
          opStack.push( token );
        }
        else if ( token == ')' )
        {
          while ( opStack.peek() != '(' )
          {
            valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
          }
          opStack.pop();
        }
        else if ( Character.isDigit( token ) )
        {
          int start = i;
          while ( i + 1 < s.length() && Character.isDigit( s.charAt( i + 1 ) ) )
          { 
            i++;
          }
          valStack.push( Integer.parseInt( s.substring( start, i + 1 ) ) );
        }
        else
        {
          while ( !opStack.isEmpty() && isLowerPrece( token, opStack.peek() ) )
          {
            valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
          }
          opStack.push( token );
        }
      }
      
      while ( !opStack.isEmpty( ) )
      {
        valStack.push( calc( opStack.pop(), valStack.pop(), valStack.pop() ) );
      }
      return valStack.pop();      
    }
        
    private boolean isLowerPrece( char curr, char toBeCompared )
    {
      return ( toBeCompared == '*' || toBeCompared == '/' ) 
          || ( toBeCompared == '-' && ( curr == '+' || curr == '-' ) );
    }
    
    private int calc( char operator, int operand1, int operand2 )
    {
      if ( operator == '+' )
      {
        return operand2 + operand1;
      }
      else if ( operator == '-' )
      {
        return operand2 - operand1;
      }
      else if ( operator == '*' )
      {
        return operand2 * operand1;
      }
      else
      {
        return operand2 / operand1;
      }
    }
```

### Parentheses 
* Check if string s contains valid parenthese
  - Questions to confirm
    + Whether the string contains non-parentheses characters
    + Whether the string contains curly braces, brackets or parentheses
    + Need to calculate the invalid number or just judge it is valid or not
```java
// Case 1: When only contains parentheses
// Judge whether a string is valid or not
boolean isValid( String s )
{
  int count = 0;
  for ( char ch : s.toCharArray() )
  {
    if ( ch == '(' )
    {
      count++;
    }
    else if ( ch == ')' )
    {
      if ( count == 0 )
      {
        return false;
      }
      count--;
    }
    // for non-parenthese chars, we will not process them
  }
  return count == 0;
}
int calcNumInvalid( String s )
{
  Stack<Character> stack = new Stack<>();
  for ( char ch : s.toCharArray() )
  {
    if ( ch == '(' ) 
    {
      stack.push( ch );
    }
    else if ( ch == ')' )
    {
      if ( !stack.isEmpty() && stack.peek() == '(' )
      {
        stack.pop();
      }
      else
      {
        stack.push( ch );
      }
    }
  }
  return stack.size();
}

// Case 2: If contains curly braces and brackets
// The basic idea is similar to Case 1. Things need to be changed here is using a Map<Ch, Ch> to store open and close mapping. 
boolean isValid( String s )
{
  Stack<Character> stack = new Stack<>();
  Map<Character, Character> openToClose = new HashMap<>();
  openToClose.put( '(', ')' );
  openToClose.put( '[', ']' );
  openToClose.put( '{', '}' );
        
  for ( char ch : s.toCharArray() )
  {
    if ( openToClose.containsKey( ch ) )
    {
      stack.push( ch );
    }
    else if ( openToClose.values.contains( ch ))
    {
      if ( stack.isEmpty() || ch != openToClose.get( stack.peek() ) )
      {
        return false;
      }
      stack.pop();
    }
  }
        
  return stack.size() == 0;
}
```
* Modifiy parenthese to make string valid
  - Questions to confirm
    + Contains other chars
    + min modification or not
    + return all valid solutions or just one solution
    + remove or insert parenthese
  - Return only one solution
    + Stack-based O(n) time and space
    + Forward/backward sweep O(n) time and O(1) space
  - Return all solutions
    + BFS-based. The hard part of this problem is how to avoid generate duplicate strings. A straightforward solution is to use HashSet to avoid. The other solution is to avoid generating using heuristics. 
    + Observations for further trunning

> 1. When we want to remove a ')' or '(' from several consecutive ones we only remove the first one, because remove any one the result will be the same. For example
> "())" ---> "()"
> only remove the first one of '))'    
>
> 2. When we remove a character it must behind it's parent removal position. 
> we need remove 2 from "(())(("
> we want to remove positions combination i,j with no duplicate
> so we let i < j then it will not generate duplicate combinations
> in practice, we record the position i and put it in to queue
> which is then polled out and used as the starting point of the next removal
> 
> 3. If the previous step we removed a "(", we should never remove a ")" in the following steps. This is obvious since otherwise we could just save these two removals and still be valid with less removals. With this observation all the possible removals will be something like this
> ")))))))))((((((((("