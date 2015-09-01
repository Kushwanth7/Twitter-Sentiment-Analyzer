package Tweetification;
import java.io.*;
public class Replacer {
	void replace(String input_file)
	{
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream(input_file);
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String s=null;
		try
		{
			while((s=br.readLine())!=null)
			{
				s = s.replaceAll("http://[a-zA-Z0-9]*.[a-zA-Z0-9]*","URL");
			}
		}
		catch(IOException e)
		{
			System.out.println("Cannot find file");
		}
	}

}
