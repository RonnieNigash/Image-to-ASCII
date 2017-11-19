import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;

import javax.imageio.*;


class ImageToAscii {


    BufferedImage img;
    double pixval;
    PrintWriter printwrite;
    FileWriter filewrite;

    public ImageToAscii() {
        try {
            printwrite = new PrintWriter(filewrite = new FileWriter("asciiart.txt",true)); // The name of the finished product
        } catch (IOException ex) {
        }
    }
    
    public void convertToAscii(String imgname) {
        try {
            img = ImageIO.read(new File(imgname));
        } catch (IOException e) {
        }


        for (int h = 0; h < img.getHeight(); h++)
        {
            for (int w = 0; w < img.getWidth(); w++)
            {
                Color pixcol = new Color(img.getRGB(w, h));
                pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11)));
                print(strChar(pixval));
            }
            try {
                printwrite.println("");
                printwrite.flush();
                filewrite.flush();
            } catch (Exception ex) {
            }
        }
    }


    public String strChar(double n)
    {
        String stringy = " ";
        if (n >= 240) {
            stringy = " ";
        } else if (n >= 210) {
            stringy = ".";
        } else if (n >= 190) {
            stringy = "*";
        } else if (n >= 170) {
            stringy = "+";
        } else if (n >= 120) {
            stringy = "^";
        } else if (n >= 110) {
            stringy = "&";
        } else if (n >= 80) {
            stringy = "8";
        } else if (n >= 60) {
            stringy = "#";
        } else {
            stringy = "@";
        }
        return stringy;
    }


    public void print(String stringy)
    {
        try {
            printwrite.print(stringy);
            printwrite.flush();
            filewrite.flush();
        } catch (Exception ex) {
        }
    }
    
    public static void main(String[] args) {
    	Scanner reader = new Scanner (System.in);
		System.out.print("Path to image: ");
		String path2img = reader.next();
		reader.close();
    	ImageToAscii obj = new ImageToAscii();
    	obj.convertToAscii(path2img); //Put your File name.jpg here !! :D
    }
}