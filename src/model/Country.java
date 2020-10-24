package model;

public class Country {
private String name;
private int money;
private int seafarerNumber;
private int aSeafarerCost;
private int merchantNumber;
private int aMerchantCost;
private int colonistNumber;
private int aColonistCost;
private int colonyspped;
private Port []hasp;
private int []tradep;
private int []colonyDoing;
private int []colonyp;
public Country(String name,int money,int sNumber,int sCost,int mNumber,
		int mCost,int cn,int cnCost,int colonySpeed){
	this.name=name;
	this.money=money;
	this.seafarerNumber=sNumber;
	this.aSeafarerCost=sCost;
	this.merchantNumber=mNumber;
	this.aMerchantCost=mCost;
	this.colonistNumber=cn;
	this.aColonistCost=cnCost;
	this.colonyspped=colonySpeed;
	this.hasp=new Port[6];
	this.tradep=new int[6];
	this.colonyp=new int[6];
	this.colonyDoing=new int[6];
	for(int i=0;i<this.colonyDoing.length;i++)
		{
		this.colonyDoing[i]=0;
		this.tradep[i]=0;
		this.colonyp[i]=0;
		}

}



public void setHasPort(int i,Port p){
	this.money-=this.aSeafarerCost;	
	this.hasp[i]=p;
}
public void setTradePort(int i){
	this.money-=this.aMerchantCost;
	this.tradep[i]++;
}
public void setColonyDoingPort(int i){

	this.colonyDoing[i]++;
	this.colonistNumber--;
}
public String getName() {
	return this.name;
	// TODO Auto-generated method stub
	
}
public int getsNumber(){
	return this.seafarerNumber;
}
public int getsCost(){
	return this.aSeafarerCost;
}
public int getmNumber(){
	return this.merchantNumber;
}
public int getmCost(){
	return this.aMerchantCost;
}
public int getcNumber(){
	return this.colonistNumber;
}
public int getcCost(){
	return this.aColonistCost;
}
public Port[]getHasPort(){
	return this.hasp;
}
public String getHasPortNames(){
	String name="";
	for(int i=0;i<this.hasp.length;i++)
		if(hasp[i]!=null)
			name=name+hasp[i].getName();
	return name;
}
public String getColonyDoingPortName(){
	String name="";
	for(int i=0;i<this.hasp.length;i++)
		if(this.colonyDoing[i]!=0)
			name=name+","+hasp[i].getName();
	return name;
}
public String getColonyPortName(){
	String name="";
	for(int i=0;i<this.hasp.length;i++)
		if(this.colonyp[i]!=0)
			name=name+hasp[i].getName();
	return name;
}
public int[]getTradePort(){
	return this.tradep;
}
public int[]getColonyPort(){
	return this.colonyp;
}
public int getMoney() {
	
	return this.money;
}
public int getAcolonistCost() {
	
	return this.aColonistCost;
}
public int getCononySpped() {
	
	return this.colonyspped;
}

public void changeMoney(int add) {
	this.money+=add;	
}
/**
 * add函数：战争胜利后获得战利品
 * @param i
 */
public void addColonist(boolean i){
	if(true==i)
		this.colonistNumber++;
	else
		this.colonistNumber--;
}

public void addMerchant(boolean i){
	if(true==i)
		this.merchantNumber++;
	else
		this.merchantNumber--;
}

public void addSeafarer(boolean i){
	if(true==i)
		this.seafarerNumber++;
	else
		this.seafarerNumber--;
}

/**
 * 国家日常开销
 */

public void dailyExpense(){
	this.money-=20;
}
/**
 * 商人回归
 */
public void resetMerchant() {
	this.tradep=new int[6];
	
}
/**
 * 殖民者胜利回家
 * @param name
 */
public void colonistHome(String name) {
	int i=0;
	while(i<this.hasp.length){
		if(this.hasp[i].getName().equals(name))
			break;
	}
	this.colonistNumber+=this.colonyDoing[i];
	this.colonyDoing[i]=0;
	this.colonySuccess(i);
}
/**
 * 殖民胜利
 * @param i
 */
public void colonySuccess(int i){
	this.colonyp[i]=1;
}
/**
 * 殖民中端
 * @param i
 */
public void colonistHome(int i) {

	this.colonistNumber+=this.colonyDoing[i];
	this.colonyDoing[i]=0;
}
/**
 * 战败失去殖民地
 * @param i
 */
public void loseColonyPort(int i) {
	this.colonyp[i]=0;
	
}
//获取大臣总数
public int getall() {
	
	return this.colonistNumber+this.merchantNumber+this.seafarerNumber;
}

}