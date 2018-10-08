package cale.impros.impros;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

public class impROS {

    public static void startAct(Activity act) {
        act.startActivity(new Intent(act, DenemeAct.class));
    }

    public final static boolean telKontrol(Context context, String strCepTel) {
        if (strCepTel.length() != 10) {
            Toast.makeText(context, "Telefon Numaranız 10 Haneli Olmalıdır.", Toast.LENGTH_LONG);
            return false;
        } else if ((strCepTel.charAt(0) + "").equalsIgnoreCase("0")) {
            Toast.makeText(context, "Telefon Numaranızı Başında 0 Olmadan Giriniz.", Toast.LENGTH_LONG);
            return false;
        } else if (!(strCepTel.charAt(0) + "").equalsIgnoreCase("5")) {
            Toast.makeText(context, "Telefon Numaranız 5 İle Başlamalıdır.", Toast.LENGTH_LONG);
            return false;
        }
        return true;
    }

    public final static boolean emailKontrol(Context context, String strEmail) {
        boolean emailKontrol = !TextUtils.isEmpty(strEmail) && android.util.Patterns.EMAIL_ADDRESS.matcher(strEmail).matches();
        if (!emailKontrol) {
            Toast.makeText(context, "Geçerli Bir Email Adresi Giriniz.", Toast.LENGTH_LONG);
            return false;
        }
        return true;
    }

    public static String getString(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        Log.d("", key + " : " + preferences.getString(key, ""));
        return preferences.getString(key, "");
    }

    public static void setInt(Context context, String key, int sayi) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = preferences.edit();
        edit.putInt(key, sayi);
        edit.commit();
    }

    public static boolean dogumTarihKontrol(Context context, String strDogumTarihi) {

        if (strDogumTarihi.length() != 10) {
            Toast.makeText(context, "Lütfen Dogum Tarihini GUN-AY-YIL Şeklinde Eksiksiz Giriniz.", Toast.LENGTH_LONG).show();
            return false;
        }
        //  //##-##-####
        int gun = Integer.parseInt(strDogumTarihi.substring(0, 2));
        int ay = Integer.parseInt(strDogumTarihi.substring(3, 5));
        int yil = Integer.parseInt(strDogumTarihi.substring(6, 10));
        if (yil < 1900) {
            Toast.makeText(context, "Doğum Tarihiniz 1900 den Büyük Olmalıdır.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (yil > 2018) {
            Toast.makeText(context, "Dogum Tarihiniz 2018 den Küçük Olmalıdır.", Toast.LENGTH_LONG).show();
            return false;
        }
        if (ay < 1 || ay > 12) {
            Toast.makeText(context, "Lütfen 1 ile 12 Arasında  Geçerli Ay Giriniz", Toast.LENGTH_LONG).show();
            return false;
        }
        if (gun < 1 || gun > 31) {
            Toast.makeText(context, "Lütfen 1 ile 31 Arasında  Geçerli Gün Ay Giriniz", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public static void log(String debugMesaj) {
        Log.d("x3k ", debugMesaj);
    }

    public static void loge(Exception ex) {
        Log.e("x3k ", "Metot : " + ex.getStackTrace()[0].getMethodName()
                + ",Satir : " + ex.getStackTrace()[0].getLineNumber()
                + ex.getMessage());
        ex.printStackTrace();
        loge(Log.getStackTraceString(ex));
    }

    public static void loge(String debugMesaj) {
        Log.e("x3k ", debugMesaj);

    }

}
