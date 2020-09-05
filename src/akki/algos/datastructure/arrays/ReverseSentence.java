package akki.algos.datastructure.arrays;

import java.util.Stack;

public class ReverseSentence {

	public static void main(String[] args) {
		String s="I AM AKHILESH";
		Stack<Character> stack=new Stack<>();
		char[] ch=s.toCharArray();
		StringBuffer sb=new StringBuffer();
		for(int i=ch.length-1;i>=0;i--){
			if(ch[i]!=' '){
				stack.add(ch[i]);
			}else{
				while(!stack.isEmpty()){
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
		}
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());

	}

}
