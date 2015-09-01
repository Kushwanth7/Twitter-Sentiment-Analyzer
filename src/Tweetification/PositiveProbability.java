package Tweetification;
import java.io.*;
public class PositiveProbability {
	private BufferedReader br;

	double compute_prob(String s, long count)
	{
		double posres=1;
		double posprior = 248610.0/497327.0;
		//System.out.println(posprior);
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\PositiveSentiment");
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found exception");
		}
		DataInputStream in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		String[] words1 = s.split("\\s+");
		double[] cpos = new double[140];
		double[] ppos = new double[140];
		
		for(int i=0;i<140;i++)
		{
			cpos[i]=0;
			ppos[i]=0;
		}
		
		for(int i=0;i<words1.length;i++)
		{
			//double count = 0;
			String sline;
			try
			{
				while((sline = br.readLine())!=null)
			{
				String[] words2 = sline.split("\\s+");
				//count += words2.length; 
				for(int j=0;j<words2.length;j++)
				{
					if(words1[i].equalsIgnoreCase(words2[j]))
					{
						cpos[i]+=1;
					}
				}
				
			}
			}
			catch(IOException e)
			{
				System.out.println("Unable to read from file");
			}
			ppos[i] = Math.log10((cpos[i]+1)/count);
			//System.out.println(cpos[i] + " " + count + " " + ppos[i]);
		}
		for(int z=0;z<words1.length;z++)
		{
			posres+=ppos[z];
			//System.out.println(posres);
		}
		posres+=Math.log10(posprior);
		//System.out.println(posres);
		return posres;
	}

}
