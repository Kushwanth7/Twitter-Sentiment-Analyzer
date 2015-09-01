package Tweetification;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartProgram
 */
@WebServlet("/StartProgram")
public class StartProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  
        // TODO Auto-generated constructor stub
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	String tweet = request.getParameter("tweet");
	String tc = request.getParameter("TweetCount");
	 String s10 = null;
	 s10 = "Analyze2.jsp";
	 if(tweet == "" || tc == "")
	 {
		 s10 = "Error.jsp";
	 }
	 if(tc.matches("[1-9][0-9]*")== false)
	 {
		 s10 = "Error.jsp";
	 }
	 else
	 {
	 int i = Integer.parseInt(tc);
	 
	 response.getWriter();
		TweetSentiment obj = new TweetSentiment();
		int [] results = obj.AnalyzeSentiment(tweet,i);
		request.setAttribute("tweet_count",results[0]);
		
		request.setAttribute("pos_count",results[1]);
		request.setAttribute("neg_count",results[2]);
		request.setAttribute("nue_count",results[3]);
		request.setAttribute("other_count",results[4]);
		 //String s1 = request.getServletContext().getRealPath("/") + "/TwitterTest";
		 //String s2 = request.getServletContext().getRealPath("/") + "/SentimentResult";
		 
		 String s1 = "C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\TwitterTest1";
		 String s2 = "C:\\Users\\ASHASHANTHARAM\\java-space\\TwitterSentimentAnalyzer\\WebContent\\SentimentResult";
		 
		 FileInputStream fstream1 = null;
		 FileInputStream fstream2 = null;
		 try
		    {
		     fstream1 = new FileInputStream(s1);
		     fstream2 = new FileInputStream(s2);
		    }
		    catch(FileNotFoundException d)
		    {
		    	System.out.println("File not found");
		    }
		 try
		 {
		 DataInputStream in1 = new DataInputStream(fstream1);
		    BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
		    DataInputStream in2 = new DataInputStream(fstream2);
		    BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
		    String st1=null;
		    String st2=null;
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("one-test",st1);
		    if(st2!=null)
			    request.setAttribute("one-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("two-test",st1);
		    if(st2!=null)
			    request.setAttribute("two-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("three-test",st1);
		    if(st2!=null)
			    request.setAttribute("three-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("four-test",st1);
		    if(st2!=null)
			    request.setAttribute("four-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("five-test",st1);
		    if(st2!=null)
			    request.setAttribute("five-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("six-test",st1);
		    if(st2!=null)
			    request.setAttribute("six-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("seven-test",st1);
		    if(st2!=null)
			    request.setAttribute("seven-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("eight-test",st1);
		    if(st2!=null)
			    request.setAttribute("eight-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("nine-test",st1);
		    if(st2!=null)
			    request.setAttribute("nine-result",st2);
		    st1 = br1.readLine();
		    st2 = br2.readLine();
		    if(st1!=null)
			    request.setAttribute("ten-test",st1);
		    if(st2!=null)
			    request.setAttribute("ten-result",st2);
		 }
		 catch (NullPointerException asd)
		    {
		    	System.out.println("Error");
		    }
	 }
	
	 
	 RequestDispatcher rd = request.getRequestDispatcher(s10);
	 rd.forward(request,response);
	 }
	 

	
	
}
