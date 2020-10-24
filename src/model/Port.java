package model;

public class Port {
private String name;
private int money;
private Country []tradeCountry;
private Country []findCountry;
private Country []colonyCoun;
private int[]resist;
private Country suzerain;

public Port(String name,int money,int resistence)
{
	this.name=name;
	this.money=money;
	resist=new int [4];
	this.findCountry=new Country[4];
	
}
//�ۿ�ó�ף�����������ƽ��ó�׶������һ����չ
public void sendMoney(){
	if(this.suzerain==null){
	int rawMoney=money;
	int countryN=0;
    if(!(this.tradeCountry==null))
    	countryN=this.tradeCountry.length;   	
	this.money=money+5;
	for(int i=0;i<countryN;i++){
		tradeCountry[i].changeMoney(rawMoney/tradeCountry.length);		
	}
	}
	else{
		this.suzerain.changeMoney(money);
		this.money=money+5;
	}
}
//ֳ����
public void colonyCost(){
	int countryN=0;
    if(!(this.colonyCoun==null))
    	countryN=this.colonyCoun.length;   		
	for(int i=0;i<countryN;i++)
	{
		this.colonyCoun[i].changeMoney(-this.colonyCoun[i].getAcolonistCost());	
	}

}
//���˵���
public void setTradeCountry(Country c){
	int len =0;
	if(this.tradeCountry!=null)
	 len=this.tradeCountry.length;
	Country []newcoun=new Country[len+1];
	for(int i=0;i<len;i++)
		newcoun[i]=this.tradeCountry[i];
	newcoun[len]=c;
	this.tradeCountry=newcoun;
}
//ֳ���ߵ���
public void setColonyCountry(Country c){
	int len =0;
	if(this.colonyCoun!=null)
	 len=this.colonyCoun.length;
	Country []newcoun=new Country[len+1];
	for(int i=0;i<len;i++)
		newcoun[i]=this.colonyCoun[i];
	newcoun[len]=c;
	this.colonyCoun=newcoun;
}
//��̽�ռҷ���
public void setFindCountry(int i,Country c){
	this.findCountry[i]=c;
}
//�����뿪
public void resetcountry(){
	this.tradeCountry=null;
}

public String getName() {
	
	return this.name;
}
/**��ֳ������Ӧ�ĵֿ�����
 * �ֿ������Թ��Ҽ����
 * ��Ϊ0��ֳ��ɹ�
 * @return
 */
public int [] getResist(){
	return resist;
}
public int getMoney(){
	return money;
}

public String getHasCountryNmae(){
	String coun="";
	for(int i=0;i<this.findCountry.length;i++)
		if(this.findCountry[i]!=null)
			coun+=findCountry[i].getName()+",";
	return coun;
}
public String getColonyCountryNmae(){
	String coun="";
	if(this.colonyCoun==null)
			return coun;
	for(int i=0;i<this.colonyCoun.length;i++){
		
		if(this.colonyCoun[i]!=null)
			coun+=colonyCoun[i].getName()+",";
	}
	return coun;
}
//�ֿ�
public void reduceResist(){
	
	for(int i=0;i<4;i++){
		if(this.colonyCoun==null)
			break;
		for(int j=0;j<this.colonyCoun.length;j++){
			if(this.findCountry[i].getName().equals(this.colonyCoun[j].getName()))
	       resist[i]-=findCountry[i].getCononySpped();
		}
	}
}
//ÿ���ж�ֳ���Ƿ�ɹ�
public void colonyisSuccess(){
	for(int i=0;i<this.resist.length;i++)
		if(resist[i]<0){
			this.successColony(this.findCountry[i]);
			this.findCountry[i].colonistHome(this.name);
		}
}
//ֳ��ɹ�
public void successColony(Country suzerain){
	this.suzerain=suzerain;
}
//ֳ���жϣ��ֿ��������ߣ��޼���ֵ
public void breakColony(int i){
	this.resist[i]+=10;
	for(int j=0;j<this.colonyCoun.length;j++)
		if(this.findCountry[i].getName().equals(this.colonyCoun[j].getName())){
			for(int k=j;k<this.colonyCoun.length;k++){
				this.colonyCoun[k]=this.colonyCoun[k+1];
				if(k==this.colonyCoun.length-2){
					this.colonyCoun[k+1]=null;
					continue;
				}
			}
			break;
		}
		
	
}
//һ�����ҳ���
public void aCountryOut(int i){
	int len=this.colonyCoun.length;
	for(int j=0;j<len;j++){
		if(this.colonyCoun[j]==this.findCountry[i]){
			for(int m=j;m<len-1;m++)
				this.colonyCoun[j]=this.colonyCoun[j+1];
			len--;
			j--;
		}
	}
	Country []co=new Country[len];	
	for(int j=0;j<len;j++)
		co[j]=this.colonyCoun[j];
	this.colonyCoun=co;
	Country []coun=new Country[this.findCountry.length-1];
	int []re=new int[this.resist.length-1];
	for(int j=0;j<=i-1;j++){			
	    coun[j]=this.findCountry[j];
	    re[j]=this.resist[j];
	}
	for(int j=i;j<this.findCountry.length-1;j++){
		coun[j]=this.findCountry[j+1];
		re[j]=this.resist[j+1];
	}
	this.findCountry=coun;
	this.resist=re;
	
}
}
