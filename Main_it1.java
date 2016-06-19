//This class acts as an interface

import java.net.* ;

public class Main_it1{
	InetAddress host;
	
	
	public static void main( String args[] ){
		
		Main_it1 m = new Main_it1();
		
		// Check the whether the arguments are given
		if( args.length != 1 ) {
			System.out.println( "usage: Peer's IP" ) ;
			return ;
		}
		
		try{
			m.host = InetAddress.getByName( args[0] ) ;
		}catch(Exception e){
			System.out.println( e ) ;
		}
		
		new ThreadPlayback().start(); //call the thread to receive and playback
		new ThreadRecord(m.host).start();//call the thread to capture and transmit
		
		
	}
}