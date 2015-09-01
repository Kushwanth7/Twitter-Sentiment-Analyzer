package Tweetification;
import java.io.*;
public class ReadTrainingData {
                 
	void TrainData(String input_file,String output_file)
	{
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream(input_file);
		}
		catch(FileNotFoundException d)
		{
			System.out.println("File not found in traindata");
		}
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		FileOutputStream out = null;
		try
		{
			out = new FileOutputStream(output_file);
		}
		catch(FileNotFoundException d)
		{
			System.out.println("File not found");
		}
		String s = null;
		try
		{
			while((s=br.readLine())!=null)
			{
				s = s.toLowerCase();
				s = s.replaceAll("http://[a-zA-Z0-9]*.[a-zA-Z0-9//]*","URL");
				s = s.replaceAll("gud","good");
        		s = s.replaceAll("@[a-zA-Z0-9]*","AT_USER");
        	   
        		
        		//s = s.replaceAll("[0-9.]*[a-zA-Z0-9]*","[a-zA-Z0-9]*");
        		s = s.replaceAll("[!$%^&*()?#]+","");
        		
				int x = s.length();
				s = new StringBuffer(s).insert(x,"\n").toString();
				byte[] buf = s.getBytes();
				out.write(buf);
			}
		}
		catch(IOException e)
		{
			System.out.println("File operation cannot be completed");
		}
	}
	
 }
