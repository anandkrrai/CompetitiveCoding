package pep;

class numberToString{

    static String[] got = { "", "thousand", "million", "billion", "trillion" };
	static String[] teens = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	static String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };

    public static String f2(int n){
        if(n>=100){
            return teens[n/100] + "hundred" + f2(n%10);
        }else if(n>=20){
            return tens[n/10] + f2(n%10);
        }else{
            return teens[n];
        }
    }

    public static String f1(int n,int i){
        if(n==0){
            return "";
        }else{
            return f1(n/1000, i+1)+ f2(n%1000) +got[i];
        }
    }

    public static void main(String[] args){
        System.out.println(f1(567412237, 0));
    }
}