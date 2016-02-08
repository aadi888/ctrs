package dsynhub.ctrs.util;

public class Validation {

	
   public static boolean checkNull(String param)
   {
	   boolean flag=false;
	   if(param==null || param.trim().length()==0)
	   {
		   flag=true;
	   }
	   return flag;
   }
	 
}
