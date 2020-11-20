package backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RemoveInvalidParenthesis {
	
	static boolean isValid(String s)
	{
		int open = 0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) == '(')
				open++;
			else if(s.charAt(i) == ')')
				open--;
			if(open < 0)
				return false;
		}
		return (open == 0);
	}
	
	static void removeInvalid(String s)
	{
		if(s.isEmpty())
			return;
		// to avoid repetition
		HashSet<String> visited = new HashSet<>();
		// queue to maintain BFS
		
		Queue<String> q = new LinkedList<>();
		String temp;
		
		q.add(s);
		visited.add(s);
		
		//if its true than we have found one answer and no need to put other str in queue
		// than search other str in same level
		boolean level = false;
		while(!q.isEmpty())
		{
			s = q.peek();
			q.poll();
			
			if(isValid(s))
			{
				System.out.println(s);
				level = true;
			}
			if(level)
				continue;
			
			for(int i=0;i<s.length();i++)
			{
				if(s.charAt(i) == '(' || s.charAt(i) == ')') // if not a variable other than brackets
				{
					// remove this bracket
					temp = s.substring(0,i) + s.substring(i+1);
					if(!visited.contains(temp))
					{
						q.add(temp);
						visited.add(temp);
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		String s = "()())()";
		removeInvalid(s);
		
		String s1 = "(v)())()";
		removeInvalid(s1);
	}

}
