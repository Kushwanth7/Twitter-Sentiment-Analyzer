package Tweetification;

public class ComputeLarge {
         int larger(double x,double y,double z)
         {
        	 if(x<0)
        		 x=-x;
        	 if(y<0)
        		 y=-y;
        	 if(z<0)
        		 z=-z;
        	 
        	 if(x>y && x>z)
        		 return 1;
        	 else if(y>x && y>z)
        		 return 2;
        	 else if((z>y && z>x)||x==y)
        		 return 3;
        	 else
        		 return 4;
         }
}
