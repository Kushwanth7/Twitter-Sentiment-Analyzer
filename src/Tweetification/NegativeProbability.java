package Tweetification;
import java.io.*;
public class NegativeProbability {
	private BufferedReader br;

	double compute_prob(String s,long count)
	{
		double negres=1;
		double negprior = 248577.0/497327.0;
		FileInputStream fstream = null;
		try
		{
			fstream = new FileInputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NegativeSentiment");
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found exception");
		}
		DataInputStream in = new DataInputStream(fstream);
		br = new BufferedReader(new InputStreamReader(in));
		String[] words1 = s.split("\\s+");
		double[] cneg = new double[140];
		double[] pneg = new double[140];
		for(int i=0;i<140;i++)
		{
			cneg[i]=0;
			pneg[i]=0;
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
				//	count++;
					if(words1[i].equalsIgnoreCase(words2[j]))
					{
						cneg[i]+=1;
					}
				}
				
			}
			}
			catch(IOException e)
			{
				System.out.println("Unable to read from file");
			}
			pneg[i] = Math.log10( (cneg[i]+1)/count);
		}
		for(int z=0;z<words1.length;z++)
		{
			negres+=pneg[z];
		}
		negres+= Math.log10(negprior);
		//System.out.println(negres);
		return negres;
	}

}

