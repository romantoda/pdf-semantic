////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

public class PdfGraphicState {
  public double line_width;
  public double miter_limit;
  public long line_cap;
  public long line_join;
  public long fill_type;
  public long stroke_type;
  public PdfRGB fill_color;
  public PdfRGB stroke_color;
  public double fill_opacity;
  public double stroke_opacity;

  public PdfGraphicState() {
    line_width = 0;
    miter_limit = 0;
    line_cap = 0;
    line_join = 0;
    fill_type = 0;
    stroke_type = 0;
    fill_color = null;
    stroke_color = null;
    fill_opacity = 0;
    stroke_opacity = 0;
  }

  public PdfGraphicState(double line_width_, double miter_limit_, long line_cap_, long line_join_, long fill_type_, long stroke_type_, PdfRGB fill_color_, PdfRGB stroke_color_, double fill_opacity_, double stroke_opacity_) {
    line_width = line_width_;
    miter_limit = miter_limit_;
    line_cap = line_cap_;
    line_join = line_join_;
    fill_type = fill_type_;
    stroke_type = stroke_type_;
    fill_color = fill_color_;
    stroke_color = stroke_color_;
    fill_opacity = fill_opacity_;
    stroke_opacity = stroke_opacity_;
  }
}
