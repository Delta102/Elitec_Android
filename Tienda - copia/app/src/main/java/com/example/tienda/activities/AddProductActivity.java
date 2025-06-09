package com.example.tienda.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tienda.R;
import com.example.tienda.models.Product;
import com.example.tienda.services.ProductsServices;
import com.example.tienda.utils.PermissionUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddProductActivity extends AppCompatActivity {
    private String currentPhotoPath;
    private static int REQUEST_IMAGE_CAPTURE = 1;
    private static int REQUEST_IMAGE_GALLERY = 2;
    private EditText etName, etPrice;
    private ImageView imgProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        etName = findViewById(R.id.etName);
        etPrice = findViewById(R.id.etPrice);
        //Referenciar imagen del producto
        imgProduct = findViewById(R.id.imgProduct);

        //Botón para tomar foto
        Button btnTakePhoto = findViewById(R.id.btnTakePhoto);

        btnTakePhoto.setOnClickListener( v -> showImageSourceDialog());

        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v->{

            String name = etName.getText().toString();
            double price = Double.parseDouble(etPrice.getText().toString());

            Product product = new Product(name, price, "IMAGEN");
            ProductsServices.addProduct(product);

            finish();
        });
    }

    private void showImageSourceDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Seleccionar Imagen")
                .setItems(new String[]{"Cámara", "Galería"}, ((dialog, which) -> {
                    if (which == 0) openCamera();
                    else openGallery();
                })).show();
    }

    private void openCamera() {
        if (PermissionUtils.checkPermission(this, Manifest.permission.CAMERA, PermissionUtils.CAMERA_PERMISSION_CODE)) {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                File photoFile = createImageFile();
                if (photoFile != null) {
                    Uri photoURI = FileProvider.getUriForFile(this,
                            getPackageName() + ".fileprovider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        }
    }

    private void openGallery(){
        if(PermissionUtils.checkPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE, PermissionUtils.GALLERY_PERMISSION_CODE)){
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(intent, REQUEST_IMAGE_GALLERY);
        }
    }

    private File createImageFile(){
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = null;
        try {
            image = File.createTempFile(
                    imageFileName,  /* prefix */
                    ".jpg",         /* suffix */
                    storageDir      /* directory */
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}