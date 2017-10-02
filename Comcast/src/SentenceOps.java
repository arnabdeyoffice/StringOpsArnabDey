import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SentenceOps {
	
	public static String concatenateList (String[] list)	{
		StringBuilder sb = new StringBuilder("");
		for (String str : list)	{
			sb.append(str + " ");
		}
		return sb.toString().trim();
	}
	
	public static String replace (String sentence, String word1, String word2 )	{
		return sentence.replaceAll(word1, word2);
	}
	
	public static String swap (String sentence, int first, int second)	{
		String[] list = sentence.split(" ");
		if (first < 1 || second < 1 || first > list.length || second > list.length)	{
			return "";
		}
		String tempString = list[first-1];
		list[first-1] = list[second-1];
		list[second-1] = tempString;
		return concatenateList(list);
	}
	
	public static String upper (String sentence, int index)	{
		String[] list = sentence.split(" ");
		if (index < 1 || index > list.length)	{
			return "";
		}
		list[index-1]=list[index-1].toUpperCase();
		return concatenateList(list);	
	}
	
	public static String reverse (String sentence)	{
		String[] list = sentence.split(" ");
		String tempString;
		for (int i=0; i<list.length/2; i++)	{
			tempString=list[i];
			list[i]=list[list.length-1-i];
			list[list.length-1-i]=tempString;
		}
		return concatenateList(list);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/**System.out.println(replace("Sam loves cats","cat","dog"));
		System.out.println(swap("Minions are yellow creatures",3,1));
		System.out.println(upper("My food tastes like chicken",5));
		System.out.println(reverse("Paper beats rock"));*/
		
		BufferedReader br = new BufferedReader(new FileReader("testIn.txt"));
		String line = br.readLine();
		while (line != null)	{
			
			/**System.out.println(line);*/
			StringBuffer sentence = new StringBuffer ("");
			StringBuffer operation = new StringBuffer ("");
			int flag=0;
			for (int i=0; i<line.length(); i++)	{
				if (line.charAt(i) == '#')	{
					flag=1;
					continue;
				}
				if (flag==0)
					sentence.append(line.charAt(i));
				else
					operation.append(line.charAt(i));
			}
			line = br.readLine();
			
			/**System.out.println(sentence.toString().trim());
			System.out.println(operation.toString().trim());*/
			String operand = operation.toString().split(" ")[0];
			String op1 = "", op2 = "";
			try {
				op1 = operation.toString().split(" ")[1]
						.replace("first", "1").replace("last", ""+
						sentence.toString().trim().split(" ").length);
				op2 = operation.toString().split(" ")[2]
						.replace("first", "1").replace("last", ""+
						sentence.toString().trim().split(" ").length);
			} catch (Exception e) {
			}
			/**System.out.println(op1 + " " + op2);*/
			
			switch (operand)	{
			case "replace"	: System.out.println(replace(sentence.toString().trim(), op1, op2));
							break;
			case "swap" : System.out.println(swap(sentence.toString().trim(), 
					Integer.parseInt(op1), Integer.parseInt(op2)));
							break;
			case "uppercase" : System.out.println(upper(sentence.toString().trim(), 
					Integer.parseInt(op1)));
							break;
			case "reverse" : System.out.println(reverse(sentence.toString().trim()));
							break;
			default : System.out.println("Operation Undefined");
			}
			
		}

	}

}
