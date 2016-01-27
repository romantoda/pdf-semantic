////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

public class PdfWatermarkParams {
  public long page_range;
  public long order_top;
  public long h_align;
  public long v_align;
  public long percentage_vals;
  public double h_value;
  public double v_value;
  public double scale;
  public double rotation;
  public double opacity;

  public PdfWatermarkParams() {
    page_range = 0;
    order_top = 0;
    h_align = 0;
    v_align = 0;
    percentage_vals = 0;
    h_value = 0;
    v_value = 0;
    scale = 0;
    rotation = 0;
    opacity = 0;
  }

  public PdfWatermarkParams(long page_range_, long order_top_, long h_align_, long v_align_, long percentage_vals_, double h_value_, double v_value_, double scale_, double rotation_, double opacity_) {
    page_range = page_range_;
    order_top = order_top_;
    h_align = h_align_;
    v_align = v_align_;
    percentage_vals = percentage_vals_;
    h_value = h_value_;
    v_value = v_value_;
    scale = scale_;
    rotation = rotation_;
    opacity = opacity_;
  }
}
