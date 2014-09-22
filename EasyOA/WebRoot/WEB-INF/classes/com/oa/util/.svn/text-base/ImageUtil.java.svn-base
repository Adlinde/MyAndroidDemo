package com.oa.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Í¼Æ¬¹¤¾ßÀà
 * @author Administrator
 *
 */
public class ImageUtil {
		public static void scaleImage(Coord c ,String orignImage,String targetImage,int width){
			try {
				BufferedImage  bi  = ImageIO.read(new File(orignImage));
				int oldWidth = bi.getWidth();				
				int oldHeight = bi.getHeight();			
				if(oldWidth>width){
					double scaleRate = oldWidth*1.0/oldHeight;
					int newHeight =(int)(width/scaleRate);
					BufferedImage  newImage  = null;
					if( c!=null){
						newImage = new BufferedImage(c.getW(),c.getH(),BufferedImage.TYPE_INT_RGB);	
					}else{
						newImage = new BufferedImage(width,newHeight,BufferedImage.TYPE_INT_RGB);
					}
					Graphics  g = newImage.getGraphics();			
					if( c!=null){
					   g.drawImage(bi, 0, 0,c.getW() ,c.getH(),
							c.getX(),c.getY(),c.getX2(),c.getY2(),null);
					}
					else{
					   g.drawImage(bi, 0, 0, width,newHeight,
									  0,0,oldWidth,oldHeight,null);
					}			
					ImageIO.write(newImage, "JPEG", new FileOutputStream(targetImage));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
}
