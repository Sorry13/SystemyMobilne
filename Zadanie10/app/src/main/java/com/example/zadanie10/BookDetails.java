package com.example.zadanie10;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BookDetails extends AppCompatActivity {
    private TextView bookTitleTextView;
    private TextView bookAuthorTextView;
    private ImageView bookCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        bookTitleTextView = findViewById(R.id.book_detail_title);
        bookAuthorTextView = findViewById(R.id.book_detail_author);
        bookCover = findViewById(R.id.img_detail_cover);

        if (getIntent().getExtras() != null) {
            Picasso.with(getApplicationContext())
                    .load("http://covers.openlibrary.org/b/id/" + getIntent().getExtras().get(MainActivity.EXTRA_IMAGE_KEY) + "-L.jpg")
                    .placeholder(R.drawable.ic_baseline_book_24).into(bookCover);

            bookAuthorTextView.setText(String.valueOf(getIntent().getExtras().get(MainActivity.EXTRA_AUTHOR_KEY)));
            bookTitleTextView.setText(String.valueOf(getIntent().getExtras().get(MainActivity.EXTRA_TITLE_KEY)));
        }

    }
}
