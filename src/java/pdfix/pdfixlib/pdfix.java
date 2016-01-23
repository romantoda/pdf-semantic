////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2015 PDFix. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


// java class definition file : Defines the entry point for native java interface.

package pdfix.pdfixlib;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pdfix extends Object {
  static {
    try {
      String path = new File(".").getCanonicalPath() + "/";
      String lib_name = "libpdfix";
      if (System.getProperty("sun.arch.data.model").equals("64"))
        lib_name += "64";
      String os_name = System.getProperty("os.name").toLowerCase();
      if (os_name.startsWith("win"))
        lib_name += ".dll";
      else if (os_name.startsWith("mac"))
        lib_name += ".dylib";
      else
        lib_name += ".so";
//      System.load(path + lib_name);
      System.load("c:\\PDFSemantic\\bin\\pdfix_jni.dll");
    }
    catch (UnsatisfiedLinkError | SecurityException | NullPointerException e) {
      System.err.println("Native code library failed to load." + e);
      System.exit(1);    }
    catch (IOException ex) {
      Logger.getLogger(pdfix.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

//  public class PdfWatermarkParams extends Object {
//    public long page_range;
//    public int order_top;
//    public long h_align;
//    public long v_align;
//    public int percentage_vals;
//    public double h_value;
//    public double v_value;
//    public double scale;
//    public double rotation;
//    public double opacity;
//    public PdfWatermarkParams() {
//      page_range = 0;
//      order_top = 0;
//      h_align = 0;
//      v_align = 0;
//      percentage_vals = 0;
//      h_value = 0;
//      v_value = 0;
//      scale = 0;
//      rotation = 0;
//      opacity = 0;
//    }
//    public PdfWatermarkParams(long _page_range, int _order_top, long _h_align, long _v_align, int _percentage_vals, double _h_value, double _v_value, double _scale, double _rotation, double _opacity) {
//      page_range = _page_range;
//      order_top = _order_top;
//      h_align = _h_align;
//      v_align = _v_align;
//      percentage_vals = _percentage_vals;
//      h_value = _h_value;
//      v_value = _v_value;
//      scale = _scale;
//      rotation = _rotation;
//      opacity = _opacity;
//    }
//  }
//
//  public class PdfPoint extends Object {
//    public double x;
//    public double y;
//    public PdfPoint() {
//      x = 0;
//      y = 0;
//    }
//    public PdfPoint(double _x, double _y) {
//      x = _x;
//      y = _y;
//    }
//  }
//
//  public class PdfDevPoint extends Object {
//    public int x;
//    public int y;
//    public PdfDevPoint() {
//      x = 0;
//      y = 0;
//    }
//    public PdfDevPoint(int _x, int _y) {
//      x = _x;
//      y = _y;
//    }
//  }
//
//  public class PdfDevRect extends Object {
//    public int left;
//    public int top;
//    public int right;
//    public int bottom;
//    public PdfDevRect() {
//      left = 0;
//      top = 0;
//      right = 0;
//      bottom = 0;
//    }
//    public PdfDevRect(int _left, int _top, int _right, int _bottom) {
//      left = _left;
//      top = _top;
//      right = _right;
//      bottom = _bottom;
//    }
//  }
//
//  public class PdfMatrix extends Object {
//    public double a;
//    public double b;
//    public double c;
//    public double d;
//    public double e;
//    public double f;
//    public PdfMatrix() {
//      a = 0;
//      b = 0;
//      c = 0;
//      d = 0;
//      e = 0;
//      f = 0;
//    }
//    public PdfMatrix(double _a, double _b, double _c, double _d, double _e, double _f) {
//      a = _a;
//      b = _b;
//      c = _c;
//      d = _d;
//      e = _e;
//      f = _f;
//    }
//  }
//
//  public class PdfRGB extends Object {
//    public int r;
//    public int g;
//    public int b;
//    public PdfRGB() {
//      r = 0;
//      g = 0;
//      b = 0;
//    }
//    public PdfRGB(int _r, int _g, int _b) {
//      r = _r;
//      g = _g;
//      b = _b;
//    }
//  }
//
//  public class PdfTextState extends Object {
//    public long font;
//    public double font_size;
//    public double char_spacing;
//    public double word_spacing;
//    public int is_fill;
//    public PdfRGB fill_color;
//    public int is_stroke;
//    public PdfRGB stroke_color;
//    public double stroke_alpha;
//    public double fillAlpha;
//    public long decoration;
//    public PdfTextState() {
//      font = 0;
//      font_size = 0;
//      char_spacing = 0;
//      word_spacing = 0;
//      is_fill = 0;
//      fill_color = null;
//      is_stroke = 0;
//      stroke_color = null;
//      stroke_alpha = 0;
//      fillAlpha = 0;
//      decoration = 0;
//    }
//    public PdfTextState(long _font, double _font_size, double _char_spacing, double _word_spacing, int _is_fill, PdfRGB _fill_color, int _is_stroke, PdfRGB _stroke_color, double _stroke_alpha, double _fillAlpha, long _decoration) {
//      font = _font;
//      font_size = _font_size;
//      char_spacing = _char_spacing;
//      word_spacing = _word_spacing;
//      is_fill = _is_fill;
//      fill_color = _fill_color;
//      is_stroke = _is_stroke;
//      stroke_color = _stroke_color;
//      stroke_alpha = _stroke_alpha;
//      fillAlpha = _fillAlpha;
//      decoration = _decoration;
//    }
//  }
//
//  public class PdfGraphicState extends Object {
//    public double line_width;
//    public double miter_limit;
//    public long line_cap;
//    public long line_join;
//    public long fill_type;
//    public long stroke_type;
//    public PdfRGB fill_color;
//    public PdfRGB stroke_color;
//    public double fill_opacity;
//    public double stroke_opacity;
//    public PdfGraphicState() {
//      line_width = 0;
//      miter_limit = 0;
//      line_cap = 0;
//      line_join = 0;
//      fill_type = 0;
//      stroke_type = 0;
//      fill_color = null;
//      stroke_color = null;
//      fill_opacity = 0;
//      stroke_opacity = 0;
//    }
//    public PdfGraphicState(double _line_width, double _miter_limit, long _line_cap, long _line_join, long _fill_type, long _stroke_type, PdfRGB _fill_color, PdfRGB _stroke_color, double _fill_opacity, double _stroke_opacity) {
//      line_width = _line_width;
//      miter_limit = _miter_limit;
//      line_cap = _line_cap;
//      line_join = _line_join;
//      fill_type = _fill_type;
//      stroke_type = _stroke_type;
//      fill_color = _fill_color;
//      stroke_color = _stroke_color;
//      fill_opacity = _fill_opacity;
//      stroke_opacity = _stroke_opacity;
//    }
//  }
//
//  public class PdfFontState extends Object {
//    public long type;
//    public long flags;
//    public PdfRect bbox;
//    public int ascent;
//    public int descent;
//    public int italic;
//    public int bold;
//    public int fixed_width;
//    public int vertical;
//    public int TT_font;
//    public int height;
//    public PdfFontState() {
//      type = 0;
//      flags = 0;
//      bbox = null;
//      ascent = 0;
//      descent = 0;
//      italic = 0;
//      bold = 0;
//      fixed_width = 0;
//      vertical = 0;
//      TT_font = 0;
//      height = 0;
//    }
//    public PdfFontState(long _type, long _flags, PdfRect _bbox, int _ascent, int _descent, int _italic, int _bold, int _fixed_width, int _vertical, int _TT_font, int _height) {
//      type = _type;
//      flags = _flags;
//      bbox = _bbox;
//      ascent = _ascent;
//      descent = _descent;
//      italic = _italic;
//      bold = _bold;
//      fixed_width = _fixed_width;
//      vertical = _vertical;
//      TT_font = _TT_font;
//      height = _height;
//    }
//  }
//
//  public class PdfPageViewParams extends Object {
//    public int width;
//    public int height;
//    public long rotate;
//    public PdfRect clip_rect;
//    public long render_flags;
//    public PdfPageViewParams() {
//      width = 0;
//      height = 0;
//      rotate = 0;
//      clip_rect = null;
//      render_flags = 0;
//    }
//    public PdfPageViewParams(int _width, int _height, long _rotate, PdfRect _clip_rect, long _render_flags) {
//      width = _width;
//      height = _height;
//      rotate = _rotate;
//      clip_rect = _clip_rect;
//      render_flags = _render_flags;
//    }
//  }

  public native long PdeAnnotElementGetAnnot(long element);
  public native long PdeElementGetType(long element);
  public native PdfRect PdeElementGetBBox(long element);
  public native long PdeElementGetParent(long element);
  public native int PdeElementGetGState(long element, long stateP, int stateSize);
  public native int PdeElementGetNumChildren(long element);
  public native long PdeElementGetChild(long element, int index);
  public native long PdeElementGetID(long element);
  public native int PdeCellGetRowSpan(long cell);
  public native int PdeCellGetColSpan(long cell);
  public native int PdeTableGetNumRows(long table);
  public native int PdeTableGetNumCols(long table);
  public native long PdeTableGetCell(long table, int row, int col);
  public native String PdeTextGetText(long text);
//  public native PdfTextState PdeTextGetTextState(long text);
  public native int PdeTextGetNumLines(long text);
  public native long PdeTextGetTextLine(long text, int index);
  public native String PdeTextLineGetText(long text_line);
//  public native PdfTextState PdeTextLineGetTextState(long line);
  public native int PdeTextLineGetNumWords(long text_line);
  public native long PdeTextLineGetWord(long text_line, int index);
  public native String PdeWordGetText(long word);
//  public native PdfTextState PdeWordGetTextState(long word);
  public native int PdeWordGetNumChars(long word);
  public native int PdeWordGetCharTextState(long word, int index, long text_state);
  public native long PdfActionGetType(long action);
  public native String PdfActionGetJavaScript(long action);
  public native long PdfAnnotGetSubtype(long annot);
  public native long PdfAnnotGetFlags(long annot);
  public native int PdfAnnotGetFillColor(long annot, long color);
  public native int PdfAnnotGetBorderColor(long annot, long color);
  public native double PdfAnnotGetBorderWidth(long annot);
  public native long PdfAnnotGetBorderStyle(long annot);
  public native String PdfAnnotGetCaption(long annot);
  public native long PdfAnnotGetFormField(long doc, long annot);
  public native String PdfAnnotGetFontName(long annot);
  public native double PdfAnnotGetFontSize(long annot);
  public native long PdfAnnotGetAction(long annot);
  public native long PdfAnnotGetAAction(long annot, long event);
  public native long PdfDigSigNew();
  public native int PdfDigSigDestroy(long dig_sig);
  public native int PdfDigSigSetReason(long dig_sig, String reason);
  public native int PdfDigSigSetLocation(long dig_sig, String value);
  public native int PdfDigSigSetContactInfo(long dig_sig, String value);
  public native int PdfDigSigSetPFXFile(long dig_sig, String pfx_file, String pfx_password);
  public native int PdfDigSigSetTimeStampServer(long dig_sig, String url, String user_name, String password);
  public native int PdfDigSigSignDoc(long dig_sig, long doc, String path);
  public native long PdfDocOpen(String path, String password);
  public native long PdfDocOpenFromMemFile(long mem_file, String password);
  public native int PdfDocAcquire(long doc);
  public native int PdfDocRelease(long doc);
  public native int PdfDocSave(long doc, String path, long flags);
  public native int PdfDocClose(long doc);
  public native int PdfDocAddWatermarkFromImage(long doc, long params, String path);
  public native int PdfDocGetNumPages(long doc);
  public native long PdfDocAcquirePage(long doc, int page_num);
  public native int PdfDocGetDocumentJavaScript(long doc, long buffer, int len);
  public native int PdfDocGetCalculatedFormFieldCount(long doc);
  public native long PdfDocGetCalculatedFormField(long doc, int index);
  public native int PdfDocGetFormFieldCount(long doc);
  public native long PdfDocGetFormField(long doc, int index);
  public native int PdfDocGetTitle(long doc, long buffer, int len);
  public native String PdfFontGetFontName(long font);
  public native String PdfFontGetFaceName(long font);
  public native String PdfFontGetSystemFontName(long font);
  public native long PdfFontGetSystemFontCharset(long font);
  public native int PdfFontGetSystemFontBold(long font);
  public native int PdfFontGetSystemFontItalic(long font);
  public native long PdfFormFieldGetFieldType(long form_field);
  public native long PdfFormFieldGetFieldFlags(long form_field);
  public native String PdfFormFieldGetFieldValue(long form_field);
  public native String PdfFormFieldGetFieldDefaultValue(long form_field);
  public native String PdfFormFieldGetFieldFullName(long form_field);
  public native String PdfFormFieldGetFieldTooltip(long form_field);
  public native int PdfFormFieldGetFieldOptionCount(long form_field);
  public native String PdfFormFieldGetFieldOptionValue(long form_field, int index);
  public native String PdfFormFieldGetFieldOptionCaption(long form_field, int index);
  public native long PdfFormFieldGetFieldAction(long form_field);
  public native String PdfFormFieldGetFieldAAction(long form_field, long event);
  public native int PdfFormFieldGetMaxLength(long form_field);
  public native String PdfFormFieldGetFontName(long annot);
  public native double PdfFormFieldGetFontSize(long annot);
  public native String PdfFormFieldGetWidgetExportValue(long form_field, long annot);
  public native long PdfImageDataNew(int width, int height, long alpha);
  public native int PdfImageDataRelease(long image_data);
  public native int PdfImageDataSave(long image_data, String path, long save_flags);
  public native int PdfImageDataSaveRect(long image_data, long dev_rect, String path, long save_flags);
  public native int PdfPageRelease(long page);
  public native int PdfPageGetCropBox(long page, long crop_box);
  public native int PdfPageGetMediaBox(long page, long media_box);
  public native long PdfPageGetRotate(long page);
  public native int PdfPageGetDefaultMatrix(long page, long matrix);
  public native int PdfPageGetNumber(long page);
  public native long PdfPageAcquirePageMap(long page, long cancel_proc, long cancel_data);
  public native int PdfPageMapRelease(long page_map);
  public native int PdfPageMapGetNumElements(long page_map);
  public native long PdfPageMapGetElement(long page_map, int index);
  public native long PdfPageViewNew(long page, long params);
  public native int PdfPageViewRelease(long page_view);
  public native int PdfPageViewGetDeviceSize(long page_view, long width, long height);
  public native int PdfPageViewDrawPage(long page_view, long cancel_proc, long cancel_data);
  public native long PdfPageViewGetImageData(long page_view);
//  public native PdfDevRect PdfPageViewRectToDevice(long page_view, long rect);
//  public native PdfDevPoint PdfPageViewPointToDevice(long page_view, long point);
  public native int PdfInitLibrary();
  public native int PdfDestroyLibrary();
  public native String PdfGetLastError();
  public native int PdfWatermarkSetDefaultParams(long params);
  public native int PdfRGBSetDefaultParams(long rgb);
  public native int PdfTextStateSetDefaultParams(long text_state);
  public native int PdfGraphicStateSetDefaultParams(long gs);
  public native int PdfFontStateSetDefaultParams(long font_state);
  public native int PdfPageViewSetDefaultParams(long params);
}
