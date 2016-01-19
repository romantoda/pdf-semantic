/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myObjects;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Roman Toda <roman.toda@gmail.com>
 */
public class Search_Params {
    
//search what
    String searchString;

    int searchFileID;
    int searchPageID;
    int searchParagraphID;
//search in      0-Files 1-Pages 2-Paragraphs
    int searchWhere; 
    
    public void clear()
    {
        setSearchParagraphID(-1);
        setSearchFileID(-1);
        setSearchPageID(-1);
        setSearchWhere(0);
        setSearchString("");
    }
    
    public int getSearchFileID() {
        return searchFileID;
    }

    public void setSearchFileID(int searchFileID) {
        this.searchFileID = searchFileID;
    }

    public int getSearchPageID() {
        return searchPageID;
    }

    public void setSearchPageID(int searchPageID) {
        this.searchPageID = searchPageID;
    }

    public int getSearchParagraphID() {
        return searchParagraphID;
    }

    public void setSearchParagraphID(int searchParagraphID) {
        this.searchParagraphID = searchParagraphID;
    }

    public int getSearchWhere() {
        return searchWhere;
    }

    public void setSearchWhere(int searchWhere) {
        this.searchWhere = searchWhere;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    public void loadFromRequest(HttpServletRequest request) {
        clear();
        try {
            setSearchString(request.getParameter("search_string"));
        } catch (NumberFormatException | NullPointerException e) {
        }        
        if (getSearchString() == null) setSearchString("");
        
        try {
            setSearchFileID(Integer.parseInt(request.getParameter("search_fileID")));
        } catch (NumberFormatException | NullPointerException e) {
        }        
        
        try {
            setSearchPageID(Integer.parseInt(request.getParameter("search_pageID")));
        } catch (NumberFormatException | NullPointerException e) {
        }
        
        try {
            setSearchParagraphID(Integer.parseInt(request.getParameter("search_paragraphID")));
        } catch (NumberFormatException | NullPointerException e) {
        }

        try {
            setSearchWhere(Integer.parseInt(request.getParameter("search_where")));
        } catch (NumberFormatException | NullPointerException e) {
        }
    }
}
