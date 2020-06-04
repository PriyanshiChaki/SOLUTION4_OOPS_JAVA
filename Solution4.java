import java.io.BufferedReader; 
import java.io.InputStreamReader; 
import java.io.IOException; 
import java.util.StringTokenizer; 
import java.util.Arrays; 
class Solution4
{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader()
        {
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next()
        {
            while(st==null||!st.hasMoreElements())
            {
                try{
                    st=new StringTokenizer(br.readLine());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt()
        {
            return Integer.parseInt(next());
        }
        double nextDouble()
        {
            return Double.parseDouble(next());
        }

    }
    public static void main(String args[])
    {
        FastReader fs= new FastReader();
        Sim sim[]= new Sim[4];
        for (int i=0;i<sim.length;i++)
        {
            sim[i]=new Sim(fs.nextInt(), fs.next(), fs.nextInt(), fs.nextDouble(), fs.next());
        }
        String search_circle=fs.next();
        double search_rate=fs.nextDouble();
        Sim arr[]= matchAndsort(sim,search_circle,search_rate);
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i].getId());
        }

    }

    public static Sim[] matchAndsort(Sim[] sim, String search_circle, double search_rate) {
        Sim newarr[]=new Sim[0];
        for(int i=0;i<sim.length;i++)
        {
            if(sim[i].getCircle().equalsIgnoreCase(search_circle)&&sim[i].getRatePerSecond()<search_rate)
            {
                newarr=Arrays.copyOf(newarr, newarr.length+1);
                newarr[newarr.length-1]=sim[i];
            }
        }
        for(int i=0;i<newarr.length-1;i++)
        {
        for(int j=0;j<newarr.length-i-1;j++)
        { if(newarr[j].getBalance()<newarr[j+1].getBalance())
            {
            Sim temp=newarr[j];
            newarr[j]=newarr[j+1];
            newarr[j+1]=temp;
        }
      }
    }
    return newarr;
}
}
class Sim 
{
    int id;
    String Company;
    int balance;
    double ratePerSecond;
    String circle;
    public int getId()
    {
        return this.id;
    }
    public String getCompany()
    {
        return this.Company;
    }
    public int getBalance()
    {
        return this.balance;
    }
    public double getRatePerSecond()
    {
        return this.ratePerSecond;
    }
    public String getCircle()
    {
        return this.circle;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public void setCompany(String Company)
    {
        this.Company=Company;
    }
    public void setBalance(int balance)
    {
        this.balance=balance;
    }
    public void setRatePerSecond(double ratePerSecond)
    {
        this.ratePerSecond=ratePerSecond;
    }
    public void setCircle(String circle)
    {
    this.circle=circle;
    } 
    public Sim(int id, String Company, int balance, double ratePerSecond, String circle)
    {
        this.id=id;
        this.Company=Company;
        this.balance=balance;
        this.ratePerSecond=ratePerSecond;
        this.circle=circle;
    }
}