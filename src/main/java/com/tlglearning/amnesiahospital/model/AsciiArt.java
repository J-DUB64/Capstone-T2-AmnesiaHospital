package com.tlglearning.amnesiahospital.model;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AsciiArt {

  public static void printAmnesiaHospitalTitle() {
    int width = 215;
    int height = 25;

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setFont(new Font("SansSerif", Font.BOLD, 20));

    Graphics2D graphics = (Graphics2D) g;
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.drawString("Amnesia Hospital", 10, 20);

    for (int y = 0; y < height; y++) {
      StringBuilder sb = new StringBuilder();
      for (int x = 0; x < width; x++) {
        sb.append(image.getRGB(x, y) == -16777216 ? " " : "?");
      }

      if (sb.toString().trim().isEmpty()) {
        continue;
      }

      System.out.println(sb);
    }
    //AsciiArt.printAmnesiaHospitalTitle();
  }
}