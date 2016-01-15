package com.skru.networkmonitor;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView                        signal_strenght_dbm;
    TextView                        operator_name_value;
    TextView                        network_type_value;
    TextView                        imei_1_value;

    SignalPhoneStateListener1       signal_listener1;
    NetworkPhoneStateListener1      network_listener1;

    TelephonyManager                telephon_manager_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signal_strenght_dbm = (TextView)findViewById(R.id.signal_strenght_dbm);
        operator_name_value = (TextView)findViewById(R.id.operator_name_value);
        network_type_value = (TextView)findViewById(R.id.network_type_value);
        imei_1_value = (TextView)findViewById(R.id.imei_1_value);
        signal_listener1 = new SignalPhoneStateListener1();
        network_listener1 = new NetworkPhoneStateListener1();

        telephon_manager_1 = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);

        telephon_manager_1.listen(signal_listener1, SignalPhoneStateListener1.LISTEN_SIGNAL_STRENGTHS);
        telephon_manager_1.listen(network_listener1, NetworkPhoneStateListener1.LISTEN_DATA_CONNECTION_STATE);
        telephon_manager_1.listen(network_listener1,NetworkPhoneStateListener1.LISTEN_SERVICE_STATE);

        operator_name_value.setText(telephon_manager_1.getNetworkOperatorName());
        imei_1_value.setText(telephon_manager_1.getDeviceId());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class SignalPhoneStateListener1 extends PhoneStateListener {
        int signalStrengthValue;

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if(telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE) {
                String ssignal = signalStrength.toString();
                String[] parts = ssignal.split(" ");
                signalStrengthValue = Integer.parseInt(parts[9]);
            } else if (telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_CDMA)
                signalStrengthValue = signalStrength.getCdmaDbm();
            else {
                if (signalStrength.getGsmSignalStrength() != 99)
                    signalStrengthValue = signalStrength.getGsmSignalStrength() * 2 - 113;
                else
                    signalStrengthValue = signalStrength.getGsmSignalStrength();
            }
            signal_strenght_dbm.setText(String.valueOf(signalStrengthValue) + " dbm");
        }

        public void onDataConnectionStateChanged(int state, int networkType) {
            String NetTypeStr = null;
            super.onDataConnectionStateChanged(state, networkType);
            switch(telephon_manager_1.getNetworkType()){
                case 0: NetTypeStr = "Brak informacji"; break;
                case 1: NetTypeStr = "GPRS"; break;
                case 2: NetTypeStr = "EDGE"; break;
                case 3: NetTypeStr = "UMTS"; break;
                case 4: NetTypeStr = "CDMA"; break;
                case 5: NetTypeStr = "EVDO_0"; break;
                case 6: NetTypeStr = "EVDO_A"; break;
                case 7: NetTypeStr = "1xRTT"; break;
                case 8: NetTypeStr = "HSDPA"; break;
                case 9: NetTypeStr = "HSUPA"; break;
                case 10: NetTypeStr = "HSPA"; break;
                case 11: NetTypeStr = "iDen"; break;
                case 12: NetTypeStr = "EVDO_B"; break;
                case 13: NetTypeStr = "LTE"; break;
                case 14: NetTypeStr = "eHRPD"; break;
                case 15: NetTypeStr = "HSPA+"; break;
            }
            network_type_value.setText(NetTypeStr);
        }
    }

    private class NetworkPhoneStateListener1 extends  PhoneStateListener{

    }
}
