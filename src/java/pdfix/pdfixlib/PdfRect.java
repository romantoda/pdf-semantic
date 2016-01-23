/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfix.pdfixlib;

/**
 *
 * @author jozef
 */
public class PdfRect {
  public double left, top, right, bottom;
  public PdfRect() {
    left = top = right = bottom = 0;
  }
  public PdfRect(double l, double t, double r, double b) {
    left = l;
    top = t;
    right = r;
    bottom = b;
  }
  public void SetRect(double l, double t, double r, double b) {
    left = l;
    top = t;
    right = r;
    bottom = b;
  }
}
