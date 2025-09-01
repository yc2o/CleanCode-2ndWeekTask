
public class codeconventionbad(){
public static void main(String argS[])
{
System.out.println("PROGRAM HITUNG gaji===>"); 
employeE_data e=new employeE_data();
e.procESScalc("budi",40,50000);
e.procESScalc("ANI",38,45000);
managEr m=new managEr("toni",60000,45);
m.HITUNGGaJI();
}}

public class employeE_data{
void procESScalc(String NAMA,int JAM,int u){
int hasil=JAM*u;
System.out.println("nama:"+NAMA+" gaji="+hasil);}}

class managEr{
String nm;
int SALARY;
int JAMkerja;
public managEr(String nm,int SALARY,int JamKerja){
this.nm=nm;this.SALARY=SALARY;this.JAMkerja=JamKerja;}
public void HITUNGGaJI(){int g=this.SALARY*this.JAMkerja;
System.out.println("ManagerName:"+nm+"->"+g);}}