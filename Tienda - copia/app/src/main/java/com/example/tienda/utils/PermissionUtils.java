package com.example.tienda.utils;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionUtils {
    // Código de Solicitud de Permisos
    public static final int CAMERA_PERMISSION_CODE = 100;
    public static final int GALLERY_PERMISSION_CODE = 101;

    // Verificar y solicitar los permisos
    public static boolean checkPermission(Activity activity, String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
            return false;
        }
        return true;
    }

    // Manejar resultado de la solicitud
    public static void handlePermissionResult(int requestCode, String[] permissions, int[] grantResults, Runnable onGranted){
        if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            onGranted.run();
        }
    }
}
