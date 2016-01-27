////////////////////////////////////////////////////////////////////////////////////////////////////
// Copyright (c) 2016 <COMPANY>. All Rights Reserved.
// This file was automatically generated
////////////////////////////////////////////////////////////////////////////////////////////////////


package pdfix.pdfixlib;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pdfix extends Object {
  static {
    try {
      String path = new File(".").getCanonicalPath() + "/";
      String lib_name = "libPdfix";
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
      System.load("c:\\work\\sources\\pdfix\\pdfix_jni_vs\\x64\\Debug\\pdfix_jni.dll");
    }
    catch (UnsatisfiedLinkError | SecurityException | NullPointerException e) {
      System.err.println("Native code library failed to load." + e);
      System.exit(1);    }
    catch (IOException ex) {
      Logger.getLogger(pdfix.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

 public native long PdeAnnotElementGetAnnot(long element);
 public native long PdeElementGetType(long element);
 public native PdfRect PdeElementGetBBox(long element);
 public native long PdeElementGetParent(long element);
 public native PdfGraphicState PdeElementGetGState(long element);
 public native int PdeElementGetNumChildren(long element);
 public native long PdeElementGetChild(long element, int index);
 public native long PdeElementGetID(long element);
 public native int PdeCellGetRowSpan(long cell);
 public native int PdeCellGetColSpan(long cell);
 public native int PdeTableGetNumRows(long table);
 public native int PdeTableGetNumCols(long table);
 public native long PdeTableGetCell(long table, int row, int col);
 public native String PdeTextGetText(long text);
 public native PdfTextState PdeTextGetTextState(long text);
 public native int PdeTextGetNumLines(long text);
 public native long PdeTextGetTextLine(long text, int index);
 public native String PdeTextLineGetText(long text_line);
 public native PdfTextState PdeTextLineGetTextState(long line);
 public native int PdeTextLineGetNumWords(long text_line);
 public native long PdeTextLineGetWord(long text_line, int index);
 public native String PdeWordGetText(long word);
 public native PdfTextState PdeWordGetTextState(long word);
 public native int PdeWordGetNumChars(long word);
 public native int PdeWordGetCharTextState(long word, int index, PdfTextState text_state);
 public native long PdfActionGetType(long action);
 public native String PdfActionGetJavaScript(long action);
 public native long PdfAnnotGetSubtype(long annot);
 public native long PdfAnnotGetFlags(long annot);
 public native int PdfAnnotGetFillColor(long annot, PdfRGB color);
 public native int PdfAnnotGetBorderColor(long annot, PdfRGB color);
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
 public native int PdfDocGetDocumentJavaScript(long doc, String buffer, int len);
 public native int PdfDocGetCalculatedFormFieldCount(long doc);
 public native long PdfDocGetCalculatedFormField(long doc, int index);
 public native int PdfDocGetFormFieldCount(long doc);
 public native long PdfDocGetFormField(long doc, int index);
 public native int PdfDocGetTitle(long doc, String buffer, int len);
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
 public native int PdfPageGetCropBox(long page, PdfRect crop_box);
 public native int PdfPageGetMediaBox(long page, PdfRect media_box);
 public native long PdfPageGetRotate(long page);
 public native int PdfPageGetDefaultMatrix(long page, PdfMatrix matrix);
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
 public native PdfDevRect PdfPageViewRectToDevice(long page_view, long rect);
 public native PdfDevPoint PdfPageViewPointToDevice(long page_view, long point);
 public native int PdfInitLibrary();
 public native int PdfDestroyLibrary();
 public native String PdfGetLastError();
 public native int PdfWatermarkSetDefaultParams(PdfWatermarkParams params);
 public native int PdfRGBSetDefaultParams(PdfRGB rgb);
 public native int PdfTextStateSetDefaultParams(PdfTextState text_state);
 public native int PdfGraphicStateSetDefaultParams(PdfGraphicState gs);
 public native int PdfFontStateSetDefaultParams(PdfFontState font_state);
 public native int PdfPageViewSetDefaultParams(PdfPageViewParams params);
 public native int PdfHtmlCreate(long doc, String save_path, long html_type);
}
