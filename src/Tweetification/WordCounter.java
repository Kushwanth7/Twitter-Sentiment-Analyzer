package Tweetification;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCounter {
 
	private BufferedReader br;

	public long word_count(String input_file)
	{
		long count= 0 ;
		FileInputStream fstream =null;
		try
		{
			fstream = new FileInputStream(input_file);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found exception");
		}
		DataInputStream in = new DataInputStream(fstream);
		br = new  BufferedReader(new InputStreamReader(in));
		String s;
		try
		{
			while((s = br.readLine())!=null)
			{
				String[] words = s.split("\\s+");
				count += words.length;
			}
		}
		catch(IOException e)
		{
			System.out.println("Cannot read from file");
		}
		return count;
	}
}

