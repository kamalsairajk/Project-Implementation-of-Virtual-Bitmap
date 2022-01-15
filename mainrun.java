import java.io.*;
import java.io.IOException;
import java.util.*;


public class mainrun{
    public static void main(String []args) throws IOException {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        FileWriter output = new FileWriter("output_proj4.txt");
        File file = new File("project4input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int numflows = Integer.parseInt(br.readLine());
        ArrayList<Flowparameters1> inparr = new ArrayList<Flowparameters1>();
        String st;
        while ((st = br.readLine()) != null)
        {
            String ipsize[] = st.split("\\s+");
            inparr.add(new Flowparameters1(ipsize[0], Integer.parseInt(ipsize[1])));
        }
            System.out.println("Enter the size of physical bitmap ");
            int m=sc.nextInt();
            System.out.println("Enter the size of virtual bitmap");
            int l=sc.nextInt();

            VirtualBitmap vb=new VirtualBitmap(m,l);
            for(Flowparameters1 p : inparr)
            {
                String flowstr = p.ip;
                int flow1=flowstr.hashCode();
                vb.record(flow1,p.actspread);
            }
            int numzeroesbpm= 0;
            for(int i=0;i<m;i++){
                if (vb.phybitmap[i]==0){
                    numzeroesbpm++;
                }
            }
            for(Flowparameters1 p : inparr)
            {
                String flowstr = p.ip;
                int flow1=flowstr.hashCode();
                double rcrdsprd=vb.query(flow1,p.actspread,numzeroesbpm);
                System.out.println(p.ip + " " +p.actspread+" "+rcrdsprd);
                output.write(p.ip + " " +p.actspread+" "+rcrdsprd + "\n");
            }
            output.close();
        }
}
class Flowparameters1 {
    String ip;
    Integer actspread;
    Flowparameters1() {

    }

    Flowparameters1(String ip, int actspread) {
        this.ip = ip;
        this.actspread = actspread;
    }
}
class VirtualBitmap{
    int l;
    int m;
    int []s;
    int [] phybitmap;
    Random randelem=new Random();
    Random rand=new Random();
    VirtualBitmap(int m, int l){
        this.l=l;
        this.m=m;
        this.phybitmap=new int[m];
        this.s=new int[l];
        Arrays.fill(phybitmap,0);
        Randomarraygen();
    }
    public void record(int flow,int size){
        for(int i=0;i<size;i++){
            int elem=Math.abs(randelem.nextInt());
            int vbl=Math.abs((Integer.toString(elem)).hashCode()%l);
            phybitmap[Math.abs((flow^s[vbl])%m)]=1;
        }
    }

    public double query(int flow,int size, int numzeroesbpm){
        int numzeroesvbm=0;
        for(int i=0;i<l;i++){
            if (phybitmap[(Math.abs(flow^s[i]))%m]==0){
                numzeroesvbm++;
            }
        }
        double Vf=(double)numzeroesvbm/ l;
        double Vb=(double)numzeroesbpm/ m;
        return Math.abs((l*Math.log(Vb))-(l*Math.log(Vf)));
    }
    public void Randomarraygen(){
        for(int i=0;i<this.l;i++){
            s[i]=Math.abs(rand.nextInt());
        }
    }
}
