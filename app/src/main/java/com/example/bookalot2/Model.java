package com.example.bookalot2;

public class Model {

    String BookName;
    String BookDtail;
    int BookPhoto;


    public Model(String bookName, String bookDtail, int bookPhoto) {
        BookName = bookName;
        BookDtail = bookDtail;
        BookPhoto = bookPhoto;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookDtail() {
        return BookDtail;
    }

    public void setBookDtail(String bookDtail) {
        BookDtail = bookDtail;
    }

    public int getBookPhoto() {
        return BookPhoto;
    }

    public void setBookPhoto(int bookPhoto) {
        BookPhoto = bookPhoto;
    }


}
