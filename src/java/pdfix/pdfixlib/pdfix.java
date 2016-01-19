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
//      System.load(lib_name);
//      System.load(myObjects.Settings.BIN_FOLDER + lib_name);
        System.loadLibrary("pdfix64");
    }
    catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load." + e);
      System.exit(1);    }
    catch (SecurityException e) {
      System.err.println("Native code library failed to load." + e);
      System.exit(1);
    }
    catch (NullPointerException e) {
      System.err.println("Native code library failed to load." + e);
      System.exit(1);
    }
    catch (IOException ex) {
      Logger.getLogger(pdfix.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public native long PdeAnnotElementGetAnnot(long element);
  public native int PdeCellGetColSpan(long cell);
  public native int PdeCellGetRowSpan(long cell);
  public native int PdeElementGetBBox(long element, long bbox);
  public native long PdeElementGetChild(long element, int index);
  public native int PdeElementGetGState(long element, long stateP, int stateSize);
  public native int PdeElementGetNumChildren(long element);
  public native long PdeElementGetParent(long element);
  public native long PdeElementGetType(long element);
  public native long PdeTableGetCell(long table, int row, int col);
  public native int PdeTableGetNumCols(long table);
  public native int PdeTableGetNumRows(long table);
  public native String PdeTextGetText(long text);
  public native int PdeTextGetTextState(long text, long text_state);
  public native String PdeTextLineGetText(long text_line);
  public native String PdfActionGetJavaScript(long action);
  public native long PdfActionGetType(long action);
  public native long PdfAnnotGetAAction(long annot, long event);
  public native long PdfAnnotGetAction(long annot);
  public native int PdfAnnotGetBorderColor(long annot, long color);
  public native long PdfAnnotGetBorderStyle(long annot);
  public native double PdfAnnotGetBorderWidth(long annot);
  public native String PdfAnnotGetCaption(long annot);
  public native int PdfAnnotGetFillColor(long annot, long color);
  public native long PdfAnnotGetFlags(long annot);
  public native String PdfAnnotGetFontName(long annot);
  public native double PdfAnnotGetFontSize(long annot);
  public native long PdfAnnotGetFormField(long doc, long annot);
  public native long PdfAnnotGetSubtype(long annot);
  public native int PdfDestroyLibrary();
  public native int PdfDigSigDestroy(long dig_sig);
  public native long PdfDigSigNew();
  public native int PdfDigSigSetContactInfo(long dig_sig, String value);
  public native int PdfDigSigSetLocation(long dig_sig, String value);
  public native int PdfDigSigSetPFXFile(long dig_sig, String pfx_file, String pfx_password);
  public native int PdfDigSigSetReason(long dig_sig, String reason);
  public native int PdfDigSigSetTimeStampServer(long dig_sig, String url, String user_name, String password);
  public native int PdfDigSigSignDoc(long dig_sig, long doc, String path);
  public native long PdfDocAcquirePage(long doc, int page_num);
  public native int PdfDocClose(long doc);
  public native long PdfDocGetCalculatedFormField(long doc, int index);
  public native int PdfDocGetCalculatedFormFieldCount(long doc);
  public native int PdfDocGetDocumentJavaScript(long doc, long buffer, int len);
  public native long PdfDocGetFormField(long doc, int index);
  public native int PdfDocGetFormFieldCount(long doc);
  public native int PdfDocGetNumPages(long doc);
  public native int PdfDocGetTitle(long doc, long buffer, int len);
  public native long PdfDocOpen(String path, String password);
  public native long PdfDocOpenFromMemFile(long mem_file, String password);
  public native int PdfDocSave(long doc, String path, long flags);
  public native String PdfFormFieldGetFieldAAction(long form_field, long event);
  public native long PdfFormFieldGetFieldAction(long form_field);
  public native String PdfFormFieldGetFieldDefaultValue(long form_field);
  public native long PdfFormFieldGetFieldFlags(long form_field);
  public native String PdfFormFieldGetFieldFullName(long form_field);
  public native String PdfFormFieldGetFieldOptionCaption(long form_field, int index);
  public native int PdfFormFieldGetFieldOptionCount(long form_field);
  public native String PdfFormFieldGetFieldOptionValue(long form_field, int index);
  public native String PdfFormFieldGetFieldTooltip(long form_field);
  public native long PdfFormFieldGetFieldType(long form_field);
  public native String PdfFormFieldGetFieldValue(long form_field);
  public native String PdfFormFieldGetFontName(long annot);
  public native double PdfFormFieldGetFontSize(long annot);
  public native int PdfFormFieldGetMaxLength(long form_field);
  public native String PdfFormFieldGetWidgetExportValue(long form_field, long annot);
  public native String PdfGetLastError();
  public native int PdfImageDataRelease(long image_data);
  public native long PdfImageDataNew(int width, int height, long alpha);
  public native int PdfImageDataSave(long image_data, String path, long save_flags);
  public native int PdfInitLibrary();
  public native long PdfPageAcquirePageMap(long page, long matrix, long cancel_proc, long cancel_data);
  public native int PdfPageDrawContentsToImage(long page, long image_data, long matrix, long clip_rect, long flags, long cancel_proc, long cancel_data);
  public native int PdfPageGetCropBox(long page, long crop_box);
  public native int PdfPageGetDefaultMatrix(long page, long matrix);
  public native int PdfPageGetDeviceMatrix(long page, long matrix, int x, int y, int width, int height, int rotate);
  public native int PdfPageGetMediaBox(long page, long media_box);
  public native int PdfPageGetNumber(long page);
  public native long PdfPageGetRotate(long page);
  public native long PdfPageMapGetElement(long page_map, int index);
  public native int PdfPageMapGetNumElements(long page_map);
  public native int PdfPageMapPointToDevice(long page_map, long point);
  public native int PdfPageMapRectToDevice(long page_map, long rect);
  public native int PdfPageMapRelease(long page_map);
  public native int PdfPageRelease(long page);
}
