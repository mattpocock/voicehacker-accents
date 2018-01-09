package uk.co.voicehacker.app.practicewords;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;

import static java.security.AccessController.getContext;

/**
 * Created by Matt on 16-May-17.
 */

public class InAppPurchase extends Activity implements BillingProcessor.IBillingHandler {


    BillingProcessor bp;

    String getKey () {

        String k = getString(R.string.key1) + getString(R.string.key2) +getString(R.string.key3) +getString(R.string.key4) +getString(R.string.key5) +getString(R.string.key6) +getString(R.string.key7) +getString(R.string.key8) +getString(R.string.key9) +getString(R.string.key10) +getString(R.string.key11);
        return k;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_purchase);
        
        bp = new BillingProcessor(this, getKey(), this);

        Button purchase = (Button) findViewById(R.id.purchasebtn);
        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getApplicationContext()
                        .getSharedPreferences(getString(R.string.preference_file_key),
                        getApplicationContext().MODE_PRIVATE);

                EditText code = (EditText) findViewById(R.id.autotext);
                String codeinput = code.getText().toString();
                String discountcode = getString(R.string.discountcode001);

                if (codeinput.equals(discountcode)) {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean(getString(R.string.purchased001), true);
                    editor.commit();
                    Toast.makeText(InAppPurchase.this,
                            "Success! You've unlocked the Premium word pack.",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(InAppPurchase.this,
                            MainActivity.class);
                    startActivity(i);
                }
                else if (!codeinput.equals("")) {
                    Toast.makeText(InAppPurchase.this, "Incorrect code - sending you to the Google Store.",
                            Toast.LENGTH_LONG).show();
                    bp.purchase(InAppPurchase.this, "premiumwordpack001");
                }
                else
                {
                    bp.purchase(InAppPurchase.this, "premiumwordpack001");
                }
            }
        });




    }

    // IBillingHandler implementation

    @Override
    public void onBillingInitialized() {
		/*
		 * Called when BillingProcessor was initialized and it's ready to purchase
		 */
    }

    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
		/*
		 * Called when requested PRODUCT ID was successfully purchased
		 */

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);

        boolean loadOwnedPurchasesFromGoogle = bp.loadOwnedPurchasesFromGoogle();

        if (loadOwnedPurchasesFromGoogle) {

            if (bp.isPurchased(productId))
                {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean(getString(R.string.purchased001), true);
                    editor.commit();
                    Toast.makeText(this, "You've purchased this item!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(InAppPurchase.this, MainActivity.class);
                    startActivity(i);
                }
            else
                {
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean(getString(R.string.purchased001), true);
                    editor.commit();
                    Toast.makeText(this, "Success! You've unlocked the Premium word pack.", Toast.LENGTH_SHORT).show(); //TODO: Make this better
                    Intent i = new Intent(InAppPurchase.this, MainActivity.class);
                    startActivity(i);
                }
        }


    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
		/*
		 * Called when some error occurred. See Constants class for more details
		 *
		 * Note - this includes handling the case where the user canceled the buy dialog:
		 * errorCode = Constants.BILLING_RESPONSE_RESULT_USER_CANCELED
		 */
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show(); //TODO: Change This To Something More Impressive

    }

    @Override
    public void onPurchaseHistoryRestored() {
		/*
		 * Called when purchase history was restored and the list of all owned PRODUCT ID's
		 * was loaded from Google Play
		 */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!bp.handleActivityResult(requestCode, resultCode, data))
            super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        if (bp != null)
            bp.release();

        super.onDestroy();
    }


}
