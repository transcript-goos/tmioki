
public class ApplicationRunner {
	public static final String SNIPER_ID = "sniper";
	public static final String SNIPER_PASSWORD = "sniper";
	private AuctionSniperDriver driver;
	
	public void startBiddingIn(final FakeAuctionServer auction){
		Thread thread = new Thread("Test Application"){
			@Override
			public void run(){
				try{
					Main.main(
							XMPP_HOSTNAME,
							SNIPER_ID,
							SNIPER_PASSWORD,
							auction.getItemId());
				}catch(Exceprion e){
					e.printStackTrace();
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		driver = new AuctionSniperDriver(1000);
		driver.showSniperStatus(STATUS_JOINING);
	}
	public void showSniperHasLostAuction(){
		driver.showsSniperStatus(STATUS_LOST);
	}
	public void stop(){
		if(driver != null){
			driver.dispose();
		}
	}
}

