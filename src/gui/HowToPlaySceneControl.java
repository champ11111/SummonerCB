package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HowToPlaySceneControl {
	private static int currentPage;
	
	public HowToPlaySceneControl() {
		HowToPlaySceneControl.currentPage = 1;
	}
	
	public static void nextPage(ImageView image) {
		setCurrentPage(getCurrentPage()+1);
		image.setImage(new Image(ClassLoader.getSystemResource(selectPage(getCurrentPage())).toString()));
	}
	
	public static void prevPage(ImageView image) {
		setCurrentPage(getCurrentPage()-1);
		image.setImage(new Image(ClassLoader.getSystemResource(selectPage(getCurrentPage())).toString()));
	}
	
	private static String selectPage(int page) {
		switch(page) {
		case 1:return "h2p/1-page.png" ;
		case 2:return "h2p/2-page.png" ;
		case 3:return "h2p/3-page.png" ;
		case 4:return "h2p/4-page.png" ;
		case 5:return "h2p/5-page.png" ;
		case 6:return "h2p/6-page.png" ;
		case 7:return "h2p/7-page.png" ;
		case 8:return "h2p/8-page.png" ;
		case 9:return "h2p/9-page.png" ;
		case 10:return "h2p/10-page.png" ;
		case 11:return "h2p/11-page.png" ;
		}return null;
	}

	public static int getCurrentPage() {
		return currentPage;
	}

	public static void setCurrentPage(int currentPage) {
		if(currentPage<1) {
			HowToPlaySceneControl.currentPage = 1;
		}else if(currentPage>11) {
			HowToPlaySceneControl.currentPage = 11;
		}else {
			HowToPlaySceneControl.currentPage =  currentPage;
		}
	}
	
	
}
