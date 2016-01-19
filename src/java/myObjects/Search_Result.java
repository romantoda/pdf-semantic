/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myObjects;

/**
 *
 * @author Roman Toda <roman.toda@gmail.com>
 */
public class Search_Result {
    Integer fileID;
    Integer pageID;
    Integer paragraphID;
    String fileName;
    Integer score;
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public Integer getFileID() {
        return fileID;
    }

    public void setFileID(Integer fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPageID() {
        return pageID;
    }

    public void setPageID(Integer pageID) {
        this.pageID = pageID;
    }

    public Integer getParagraphID() {
        return paragraphID;
    }

    public void setParagraphID(Integer paragraphID) {
        this.paragraphID = paragraphID;
    }
   
}
