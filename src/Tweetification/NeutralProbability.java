package Tweetification;
import java.io.*;
public class NeutralProbability {
	private BufferedReader br;

	double compute_prob(String s,long count)
	{
		double neures=1;
		double neuprior = 140.0/497327.0;
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NeutralSentiment");
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found exception");
		}
		DataInputStream in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		String[] words1 = s.split("\\s+");
		double[] cneu = new double[140];
		double[] pneu = new double[140];
		for(int i=0;i<140;i++)
		{
			cneu[i]=0;
			pneu[i]=0;
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
				for(int j=0;j<words2.length;j++)
				{
					//count++;
					if(words1[i].equalsIgnoreCase(words2[j]))
					{
						cneu[i]+=1;
					}
				}
				
			}
			}
			catch(IOException e)
			{
				System.out.println("Unable to read from file");
			}
			pneu[i] = Math.log10( (cneu[i]+1)/count);
		}
		for(int z=0;z<words1.length;z++)
		{
			neures+=pneu[z];
		}
		neures+=Math.log10(neuprior);
		//System.out.println(neures);
		return neures;
	}

}
