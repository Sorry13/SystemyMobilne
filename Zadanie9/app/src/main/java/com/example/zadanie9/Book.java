package com.example.zadanie9;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book")
public class Book {

        @PrimaryKey(autoGenerate = true)
        private int id;
        private String title;
        private String author;

        public int getId() {
                return id;
        }

        public String getAuthor() {
                return author;
        }

        public String getTitle() {
                return title;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public void setId(int id) {
                this.id = id;
        }

        public void setTitle(String title) {
                this.title = title;
        }
}
