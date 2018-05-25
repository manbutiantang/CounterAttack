package wang.learn.javanet.ChapterTwo;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @author ice
 * @date 2018年5月22日
 */
public class InetAddressExample {
	
	public static void main(String[] args) {
		try {
			Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			if(interfaceList == null){
				System.out.println("-- No interface found --");
			}else{
				while(interfaceList.hasMoreElements()){
					NetworkInterface iface = interfaceList.nextElement();
					System.out.println("Interface "+iface.getName() + ":");
					Enumeration<InetAddress> addrList = iface.getInetAddresses();
					if(!addrList.hasMoreElements()){
						System.out.println("\t(NO address for this interface)");
					}
					while(addrList.hasMoreElements()){
						InetAddress address = addrList.nextElement();
						System.out.print("\tAddress"+((address instanceof Inet4Address ? "(v4)":(address instanceof Inet6Address ? "(v6)":"(?)"))));
						System.out.println(": " + address.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			System.out.println("Error getting network interfaces:"+e.getMessage());
		}
		for(String host : args){
			System.out.println(host + ":");
			try {
				InetAddress[] addressList = InetAddress.getAllByName(host);
				for(InetAddress address : addressList){
					System.out.println("\t" + address.getHostName() + "/" + address.getHostAddress());
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
