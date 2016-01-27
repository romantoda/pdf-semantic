////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

public class PdfTextState {
  public long font;
  public double font_size;
  public double char_spacing;
  public double word_spacing;
  public long is_fill;
  public PdfRGB fill_color;
  public long is_stroke;
  public PdfRGB stroke_color;
  public double stroke_alpha;
  public double fillAlpha;
  public long decoration;

  public PdfTextState() {
    font = 0;
    font_size = 0;
    char_spacing = 0;
    word_spacing = 0;
    is_fill = 0;
    fill_color = null;
    is_stroke = 0;
    stroke_color = null;
    stroke_alpha = 0;
    fillAlpha = 0;
    decoration = 0;
  }

  public PdfTextState(long font_, double font_size_, double char_spacing_, double word_spacing_, long is_fill_, PdfRGB fill_color_, long is_stroke_, PdfRGB stroke_color_, double stroke_alpha_, double fillAlpha_, long decoration_) {
    font = font_;
    font_size = font_size_;
    char_spacing = char_spacing_;
    word_spacing = word_spacing_;
    is_fill = is_fill_;
    fill_color = fill_color_;
    is_stroke = is_stroke_;
    stroke_color = stroke_color_;
    stroke_alpha = stroke_alpha_;
    fillAlpha = fillAlpha_;
    decoration = decoration_;
  }
}
