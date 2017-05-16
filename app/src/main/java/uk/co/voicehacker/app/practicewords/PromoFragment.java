package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Matt on 16-May-17.
 */

public class PromoFragment extends Fragment {

    public static PromoFragment newInstance() {
        PromoFragment promoFragment = new PromoFragment();
        return promoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.promo_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btn = (Button) getView().findViewById(R.id.promobtn);
        btn.setText("Get");

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getContext(), InAppPurchase.class);
                startActivity(i);
            }
        });

        TextView txt = (TextView) getView().findViewById(R.id.promotxt);
        txt.setText("Get over 1,000 practice words by purchasing the full version.");
    }

}
