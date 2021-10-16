package com.example.hf3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HF3_2_TableLayoutDemo extends AppCompatActivity {
    private EditText codeInput;
    private EditText nameInput;
    private EditText priceInput;
    private ArrayList<Product> productList;
    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hf_3_2_table_layout);

        codeInput=findViewById(R.id.editProductCode);
        nameInput=findViewById(R.id.editProductName);
        priceInput=findViewById(R.id.editProductPrice);

        Button saveButton = findViewById(R.id.buttonSave);
        Button cancelButton = findViewById(R.id.buttonCancel);
        Button showAllButton = findViewById(R.id.buttonViewAll);

        if (savedInstanceState==null) productList = new ArrayList<Product>();
        context=HF3_2_TableLayoutDemo.this;

        saveButton.setOnClickListener(view->{
            try
            {
                productList.add( new Product(codeInput.getText().toString(),
                        nameInput.getText().toString(),
                        Double.parseDouble(priceInput.getText().toString()) )
                );

            } catch(NumberFormatException ex){
                Toast.makeText(this,"Hibas szamformatumu ar!",Toast.LENGTH_SHORT).show();
            } finally {
                codeInput.setText(null);
                nameInput.setText(null);
                priceInput.setText(null);
            }

        });

        cancelButton.setOnClickListener(view->{
            codeInput.setText(null);
            nameInput.setText(null);
            priceInput.setText(null);
        });

        showAllButton.setOnClickListener( (View view) ->{

            TableLayout table =  findViewById(R.id.productsView);
            table.removeViews(1, table.getChildCount() - 1);

            for (Product product: productList) {
                    TableRow  row = new TableRow(this);

                    TextView codeCol =new TextView(this);
                    TextView nameCol =new TextView(this);
                    TextView priceCol =new TextView(this);

                    codeCol.setText(product.getProductCode());

                    codeCol.setLayoutParams(new TableRow.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    1
                            )
                    );

                    nameCol.setText(product.getProductName());

                    nameCol.setLayoutParams(new TableRow.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            2
                    ));

                    priceCol.setText(String.valueOf(product.getProductPrice()));

                    priceCol.setLayoutParams(new TableRow.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            1
                            )
                    );

                    row.addView(codeCol,0);
                    row.addView(nameCol,1);
                    row.addView(priceCol,2);

                    table.addView(row);

            }
        });
    }
}