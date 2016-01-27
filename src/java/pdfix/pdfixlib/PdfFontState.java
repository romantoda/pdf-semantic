////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

public class PdfFontState {
  public long type;
  public long flags;
  public PdfRect bbox;
  public int ascent;
  public int descent;
  public long italic;
  public long bold;
  public long fixed_width;
  public long vertical;
  public long TT_font;
  public int height;

  public PdfFontState() {
    type = 0;
    flags = 0;
    bbox = null;
    ascent = 0;
    descent = 0;
    italic = 0;
    bold = 0;
    fixed_width = 0;
    vertical = 0;
    TT_font = 0;
    height = 0;
  }

  public PdfFontState(long type_, long flags_, PdfRect bbox_, int ascent_, int descent_, long italic_, long bold_, long fixed_width_, long vertical_, long TT_font_, int height_) {
    type = type_;
    flags = flags_;
    bbox = bbox_;
    ascent = ascent_;
    descent = descent_;
    italic = italic_;
    bold = bold_;
    fixed_width = fixed_width_;
    vertical = vertical_;
    TT_font = TT_font_;
    height = height_;
  }
}
