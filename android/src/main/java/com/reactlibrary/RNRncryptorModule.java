
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import android.util.Base64;
import org.cryptonode.jncryptor.*;

public class RNRncryptorModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNRncryptorModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRncryptor";
  }

  @ReactMethod
  public void encrypt(String text, String password, Promise promise) {
    JNCryptor cryptor = new AES256JNCryptor();
    byte[] plaintext = text.getBytes();

    try {
      byte[] ciphertext = cryptor.encryptData(plaintext, password.toCharArray());
      String base64 = Base64.encodeToString(ciphertext, Base64.DEFAULT);
      promise.resolve(base64);
    } catch (CryptorException e) {
      e.printStackTrace();
      promise.reject(e);
    }
  }

  @ReactMethod
  public void decrypt(String encrypted, String password, Promise promise) {
    JNCryptor cryptor = new AES256JNCryptor();
    byte[] data = Base64.decode(encrypted, Base64.DEFAULT);

    try {
      byte[] text = cryptor.decryptData(data, password.toCharArray());
      promise.resolve(new String(text));
    } catch (CryptorException e) {
      e.printStackTrace();
      promise.reject(e);
    }
  }
}