package Tweetification;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;
import java.util.List;
public class TweetSentiment{
	
	private BufferedReader br2;

	public int[]  AnalyzeSentiment(String s, int c)
	{
		int tweet_count=0;
		FileOutputStream twitter_test = null;
		FileOutputStream twitter_test1 = null;
		c = c/15;
		if(c==0)
			c=1;
		//FileOutputStream twitter_test1 = null;
		try
		{
			twitter_test = new FileOutputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\TwitterTest");
			twitter_test1 = new FileOutputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\TwitterTest1");
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		int result1;
		int [] results=new int[5];
		//int pos_sentiment=0,neg_sentiment=0,neu_sentiment=0;
	ConfigurationBuilder cb = new ConfigurationBuilder();
	cb.setOAuthConsumerKey("JxcBneCgXbnRgBYDayqZw");
	cb.setOAuthConsumerSecret("H7z1vYpl4Q8rC6L7iueFcZ5X2pxwlfkLzuNq37EdM");
	cb.setOAuthAccessToken("1186416008-38JY8lSYJ7ZKkbctChcQQht1FTYZBvjFw3PUMRh");
	cb.setOAuthAccessTokenSecret("zIdOOZS7065cU3awsjMYbtdGcylRoQvIfQiMtODzg");
    Twitter twitter = new TwitterFactory(cb.build()).getInstance();
    Query query = new Query(s);
    try
    {
    	
    	QueryResult result = null;
        for(int j=0;j<c;j++)
        {
        result = twitter.search(query);
    	List<Status> tweets = result.getTweets();
    	for(Status tweet : tweets)
    	{
    		
    		String twit_text = "@" + tweet.getUser().getScreenName()+" " + "-" +" " +tweet.getText();
    		System.out.println(twit_text);
    		int len = twit_text.length();
    		twit_text = twit_text.replaceAll("\n"," ");
    		twit_text = new StringBuffer(twit_text).insert(len,"\n").toString();
    		byte[] buf = twit_text.getBytes();
    		twitter_test1.write(buf);
    		twit_text = twit_text.toLowerCase();
    		twit_text = twit_text.replaceAll("http://[a-zA-Z0-9]*.[a-zA-Z0-9//]*","URL");
    		
    		twit_text = twit_text.replaceAll("@[a-zA-Z0-9]*","AT_USER");
    		twit_text = twit_text.replaceAll("gud","good");
    
    		twit_text = twit_text.replaceAll("[?#]+"," ");
    		
    		//twit_text = twit_text.replaceAll("[\s]+"," ");
    		
    		
    		byte[] buf10 = twit_text.getBytes();
    		twitter_test.write(buf10);
    	
    		//System.out.println("@" + tweet.getUser().getScreenName()+" " + "-" +" " +twit_text);
    	    tweet_count++;	
    	}
    	query = result.nextQuery();
        }
    System.out.println(tweet_count + "Tweets retrived");
    }
    
    catch(TwitterException te)
    {
    	System.out.println("Could not retrieve tweets" + te.getMessage());
    } 
    catch(NullPointerException x)
    {
    	System.out.println("Cannot retrive anymore tweets");
    }
    catch (IOException x)
    {
    	System.out.println("Cannot write to file");
    }
   try
   {
	   twitter_test.close();
	   twitter_test1.close();
   }
   catch(IOException e)
   {
	   System.out.println("cannot close file");
   }
   ReadTrainingData obj = new ReadTrainingData();
   obj.TrainData("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\positive","C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\PositiveSentiment");
   obj.TrainData("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\negative","C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NegativeSentiment");
   obj.TrainData("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\neutral","C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NeutralSentiment");
   PositiveProbability pos_obj = new PositiveProbability();
   NegativeProbability neg_obj = new NegativeProbability();
   NeutralProbability neu_obj = new NeutralProbability();
   ComputeLarge comp_obj = new ComputeLarge();
   double pos_res,neg_res,neu_res;
   FileOutputStream ostream = null;
  
   long poscount = 0,neucount = 0,negcount = 0;
   WordCounter w = new WordCounter();
   poscount = w.word_count("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\PositiveSentiment");
   negcount = w.word_count("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NegativeSentiment");
   neucount = w.word_count("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\NeutralSentiment");
   
   
   FileInputStream fstream1 = null;
	try
	{
		fstream1 = new FileInputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\TwitterTest");
	}
	catch(FileNotFoundException d)
	{
		System.out.println("File not found in twitterTest");
	}
	DataInputStream in = new DataInputStream(fstream1);
	br2 = new BufferedReader(new InputStreamReader(in));
   
   try
   {	
	   ostream = new FileOutputStream("C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\SentimentResult");
   }
   catch(FileNotFoundException e)
   {
	   System.out.println("File not found in sentiment result");
   }
   try
   {
	   String s5;
	   String s1 = "Positive\n";
	   String s2 = "Negative\n";
	   String s3 = "Neutral\n";
	   String s4 = "Other\n";
	   int m=1;
	   int pos_sentiment=0;
	   int neg_sentiment=0;
	   int neu_sentiment=0;
	   int others =0;
	    
	   while((s5=br2.readLine())!=null)
	   {
		   
		   pos_res = pos_obj.compute_prob(s5,poscount);
		   neg_res = neg_obj.compute_prob(s5,negcount);
		   neu_res = neu_obj.compute_prob(s5,neucount);
		   result1 = comp_obj.larger(pos_res,neg_res,neu_res);
		   switch(result1)
		   {
		   case 1: pos_sentiment++;
		           s5 = s5 + " -> Positive";
			   	   byte[] b1 = s1.getBytes();
		           ostream.write(b1);
		           break;
		   case 2: neg_sentiment++;
		   		   s5 = s5 + " -> Negative";
			       byte[] b2 = s2.getBytes();
                   ostream.write(b2);
                   break;        
		   case 3: neu_sentiment++;
		   		   s5 = s5 + " -> Neutral";
			       byte[] b3 = s3.getBytes();
                   ostream.write(b3);
                   break;        
		   case 4: others++;
		   		   s5 = s5 + " -> Others";
			   	   byte[] b4 = s4.getBytes();
                   ostream.write(b4);
                   break;        
		   }
		   System.out.println("line" +m+"="+s5);
		   m++;
	   }
	  int i=0;
	  results[0]=tweet_count;
	  results[1]=pos_sentiment;
	  results[2]=neg_sentiment;
	  results[3]=neu_sentiment;
	  results[4]=others;
	  //while(i<5)
	   //System.out.println("Results for pichart="+results[i++]); 
   }
   catch(IOException e)
   {
	   System.out.println("Cannot write to file"); 
   }
  
	try 
	{
		ostream.close();
	}
	catch (IOException e)
	{
			 System.out.println("Cannot write to file"); 
	}	
   return results;
	}

	
	
	
}
