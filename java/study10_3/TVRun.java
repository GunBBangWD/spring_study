package study10_3;

class TV {
	private int size;
	public TV(int size) {
		this.size=size;
	}
	protected int getSize() {
		return size;
	}
}
class ColorTV extends TV{
	private int resolution;
	public ColorTV(int size,int resolution) {
		super(size);
		this.resolution=resolution;
	}
	protected int getResolution() {
		return resolution;
	}
	public void printProperty() {
		System.out.println(getSize()+"인치 "+resolution+"컬러");
	}
}
class IPTV extends ColorTV{
	private String address;
	public IPTV(String address,int size,int resolution) {
		super(size,resolution);
		this.address=address;
	}
	protected String getAddress() {
		return address;
	}
	@Override
	public void printProperty() {
		System.out.printf("IPTV는 %s 주소의 %d인치 %d컬러\n",
						address,getSize(),getResolution());
	}	
}
public class TVRun {
	public static void main(String[] args) {
		ColorTV ctv = new ColorTV(32,1024);//size,resolution
		ctv.printProperty();
		//32인치 1024컬러
		IPTV iptv = new IPTV("192.1.1.4",64,2048);//address,size...
		iptv.printProperty();
		//IPTV는 192.1.1.4 주소의 64인치 2048컬러
	}
}
