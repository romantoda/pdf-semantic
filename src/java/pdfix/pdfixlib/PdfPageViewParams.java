////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

public class PdfPageViewParams {
  public int width;
  public int height;
  public long rotate;
  public PdfRect clip_rect;
  public long render_flags;

  public PdfPageViewParams() {
    width = 0;
    height = 0;
    rotate = 0;
    clip_rect = null;
    render_flags = 0;
  }

  public PdfPageViewParams(int width_, int height_, long rotate_, PdfRect clip_rect_, long render_flags_) {
    width = width_;
    height = height_;
    rotate = rotate_;
    clip_rect = clip_rect_;
    render_flags = render_flags_;
  }
}
