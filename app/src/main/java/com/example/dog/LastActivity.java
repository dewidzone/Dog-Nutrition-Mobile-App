package com.example.dog;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dog.DBHandle.OrderContract;


public class LastActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {


    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber, ItemName, ItemPrice;

    Button addtoCart;
    int quantity;
    public Uri mCurrentCartUri;
    boolean hasAllRequiredValues = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);


        imageView = findViewById(R.id.imageViewInfo);
        plusquantity = findViewById(R.id.addquantity);
        minusquantity  = findViewById(R.id.subquantity);
        quantitynumber = findViewById(R.id.quantity);
        ItemName = findViewById(R.id.ItemNameinInfo);
        ItemPrice = findViewById(R.id.ItemPrice);

        addtoCart = findViewById(R.id.addtocart);

        ItemName.setText("Raw Ternative");


        addtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LastActivity.this, FinalViewActivity.class);
                startActivity(intent);
                SaveCart();
            }
        });

        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 2000;
                quantity++;
                displayQuantity();
                int cPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(cPrice);
                ItemPrice.setText(setnewPrice);
            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 2000;

                if (quantity == 0) {
                    Toast.makeText(LastActivity.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int cPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(cPrice);
                    ItemPrice.setText(setnewPrice);
                }
            }
        });
    }

    private boolean SaveCart() {

        // getting the values from our views
        String name = ItemName.getText().toString();
        String price = ItemPrice.getText().toString();
        String quantity = quantitynumber.getText().toString();

        ContentValues values = new ContentValues();
        values.put(OrderContract.OrderEntry.COLUMN_NAME, name);
        values.put(OrderContract.OrderEntry.COLUMN_PRICE, price);
        values.put(OrderContract.OrderEntry.COLUMN_QUANTITY, quantity);

        hasAllRequiredValues = true;
        return hasAllRequiredValues;

    }

    private void displayQuantity() {
        quantitynumber.setText(String.valueOf(quantity));
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {OrderContract.OrderEntry._ID,
                OrderContract.OrderEntry.COLUMN_NAME,
                OrderContract.OrderEntry.COLUMN_PRICE,
                OrderContract.OrderEntry.COLUMN_QUANTITY,

        };

        return new CursorLoader(this, mCurrentCartUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        if (cursor == null || cursor.getCount() < 1) {
            return;
        }

        if (cursor.moveToFirst()) {

            int name = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_NAME);
            int price = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_PRICE);
            int quantity = cursor.getColumnIndex(OrderContract.OrderEntry.COLUMN_QUANTITY);

            String nameofitem = cursor.getString(name);
            String priceofitem = cursor.getString(price);
            String quantityofitem = cursor.getString(quantity);

            ItemName.setText(nameofitem);
            ItemPrice.setText(priceofitem);
            quantitynumber.setText(quantityofitem);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        ItemName.setText("");
        ItemPrice.setText("");
        quantitynumber.setText("");
    }
}