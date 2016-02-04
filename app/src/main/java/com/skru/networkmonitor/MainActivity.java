package com.skru.networkmonitor;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    TextView                        rsrq_name;
    TextView                        rssnr_name;
    TextView                        rsrp_name;
    TextView                        rsrp_value;
    TextView                        rsrq_value;
    TextView                        rssnr_value;
    TextView                        operator_name_value;
    TextView                        network_type_value;
    TextView                        country_name_value;
    TextView                        asu_value;
    TextView                        power_value;
    TextView                        ci_value;
    TextView                        pci_value;
    TextView                        tac_value;
    TextView                        neighbor1_network_type_value;
    TextView                        pci_name, tac_name, ci_name;
    TextView                        neighbor_name;

    TextView                        rsrq_name1;
    TextView                        rssnr_name1;
    TextView                        rsrp_name1;
    TextView                        rsrp_value1;
    TextView                        rsrq_value1;
    TextView                        rssnr_value1;
    TextView                        asu_value1;
    TextView                        power_value1;
    TextView                        ci_value1;
    TextView                        pci_value1;
    TextView                        tac_value1;
    TextView                        pci_name1, tac_name1, ci_name1;
    TextView                        asu_name1;
    TextView                        power_name1;

    TextView                        rsrq_name2;
    TextView                        rssnr_name2;
    TextView                        rsrp_name2;
    TextView                        rsrp_value2;
    TextView                        rsrq_value2;
    TextView                        rssnr_value2;
    TextView                        asu_value2;
    TextView                        power_value2;
    TextView                        ci_value2;
    TextView                        pci_value2;
    TextView                        tac_value2;
    TextView                        pci_name2, tac_name2, ci_name2;
    TextView                        asu_name2;
    TextView                        power_name2;


    SignalPhoneStateListener        signal_listener;
    NetworkPhoneStateListener       network_listener;
    CellInfoStateListener           cell_info_state_listener;

    TelephonyManager                telephon_manager_1;

    List<CellInfo>                  cellInfoList;

    CellInfoLte                     cellInfoLte;
    CellInfoGsm                     cellInfoGsm;
    CellInfoWcdma                   cellInfoWcdma;
    CellInfoCdma                    cellInfoCdma;

    CellIdentityLte                 cellIdentityLte;
    CellIdentityGsm                 cellIdentityGsm;
    CellIdentityWcdma               cellIdentityWcdma;

    CellSignalStrengthWcdma         cellSignalStrengthWcdma;
    CellSignalStrengthGsm           cellSignalStrengthGsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operator_name_value          = (TextView) findViewById(R.id.operator_name_value);
        network_type_value           = (TextView) findViewById(R.id.network_type_value);
        country_name_value           = (TextView) findViewById(R.id.country_name_value);
        rsrp_value                   = (TextView) findViewById(R.id.rsrp_value);
        rsrq_value                   = (TextView) findViewById(R.id.rsrq_value);
        rssnr_value                  = (TextView) findViewById(R.id.rssnr_value);
        asu_value                    = (TextView) findViewById(R.id.asu_value);
        power_value                  = (TextView) findViewById(R.id.power_value);
        ci_value                     = (TextView) findViewById(R.id.ci_value);
        pci_value                    = (TextView) findViewById(R.id.pci_value);
        tac_value                    = (TextView) findViewById(R.id.tac_value);
        rsrp_name                    = (TextView)findViewById(R.id.rsrp_name);
        neighbor1_network_type_value = (TextView)findViewById(R.id.neighbor1_network_type_value);
        ci_name                      = (TextView)findViewById(R.id.ci_name);
        tac_name                     = (TextView)findViewById(R.id.tac_name);
        pci_name                     = (TextView)findViewById(R.id.pci_name);
        rsrq_name                    = (TextView)findViewById(R.id.rsrq_name);
        rssnr_name                   = (TextView)findViewById(R.id.rssnr_name);
        neighbor_name                = (TextView)findViewById(R.id.textView5);

        rsrp_value1                   = (TextView) findViewById(R.id.rsrp_value1);
        rsrq_value1                   = (TextView) findViewById(R.id.rsrq_value1);
        rssnr_value1                  = (TextView) findViewById(R.id.rssnr_value1);
        asu_value1                    = (TextView) findViewById(R.id.asu_value1);
        power_value1                  = (TextView) findViewById(R.id.power_value1);
        ci_value1                     = (TextView) findViewById(R.id.ci_value1);
        pci_value1                    = (TextView) findViewById(R.id.pci_value1);
        tac_value1                    = (TextView) findViewById(R.id.tac_value1);
        rsrp_name1                    = (TextView)findViewById(R.id.rsrp_name1);
        ci_name1                      = (TextView)findViewById(R.id.ci_name1);
        tac_name1                     = (TextView)findViewById(R.id.tac_name1);
        pci_name1                     = (TextView)findViewById(R.id.pci_name1);
        rsrq_name1                    = (TextView)findViewById(R.id.rsrq_name1);
        rssnr_name1                   = (TextView)findViewById(R.id.rssnr_name1);
        asu_name1                     = (TextView)findViewById(R.id.asu_name1);
        power_name1                   = (TextView)findViewById(R.id.power_name1);

        rsrp_value2                   = (TextView) findViewById(R.id.rsrp_value2);
        rsrq_value2                   = (TextView) findViewById(R.id.rsrq_value2);
        rssnr_value2                  = (TextView) findViewById(R.id.rssnr_value2);
        asu_value2                    = (TextView) findViewById(R.id.asu_value2);
        power_value2                  = (TextView) findViewById(R.id.power_value2);
        ci_value2                     = (TextView) findViewById(R.id.ci_value2);
        pci_value2                    = (TextView) findViewById(R.id.pci_value2);
        tac_value2                    = (TextView) findViewById(R.id.tac_value2);
        rsrp_name2                    = (TextView)findViewById(R.id.rsrp_name2);
        ci_name2                      = (TextView)findViewById(R.id.ci_name2);
        tac_name2                     = (TextView)findViewById(R.id.tac_name2);
        pci_name2                     = (TextView)findViewById(R.id.pci_name2);
        rsrq_name2                    = (TextView)findViewById(R.id.rsrq_name2);
        rssnr_name2                   = (TextView)findViewById(R.id.rssnr_name2);
        asu_name2                     = (TextView)findViewById(R.id.asu_name2);
        power_name2                   = (TextView)findViewById(R.id.power_name2);


        signal_listener              = new SignalPhoneStateListener();
        network_listener             = new NetworkPhoneStateListener();
        cell_info_state_listener     = new CellInfoStateListener();

        telephon_manager_1           = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        telephon_manager_1.listen(signal_listener, SignalPhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        telephon_manager_1.listen(network_listener, NetworkPhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
        telephon_manager_1.listen(cell_info_state_listener, CellInfoStateListener.LISTEN_CELL_INFO);

        operator_name_value.setText(telephon_manager_1.getNetworkOperatorName());
        country_name_value.setText(telephon_manager_1.getNetworkCountryIso().toUpperCase());

        Log.i("SIZE", Integer.toString(telephon_manager_1.getNeighboringCellInfo().size()));
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


    private class SignalPhoneStateListener extends PhoneStateListener {
        int signalStrengthValue,rsrp,rsrq,rssnr;

        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);

            if (telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE) {
                Log.i("TAG ", "LTE");
                String ssignal = signalStrength.toString();

                String[] parts = ssignal.split(" ");

                rsrp = Integer.parseInt(parts[9]);
                rsrq = Integer.parseInt(parts[10]);
                rssnr = Integer.parseInt(parts[11]) / 10;

                cellInfoList = telephon_manager_1.getAllCellInfo();
                if (cellInfoList != null && (cellInfoList.get(0) instanceof CellInfoLte)) {
                    cellInfoLte = (CellInfoLte) cellInfoList.get(0);
                    cellIdentityLte = cellInfoLte.getCellIdentity();

                    rsrp_name.setText("RSRP:");
                    rsrq_name.setText("RSRQ:");
                    rssnr_name.setText("RSSNR:");
                    tac_name.setText("TAC:");
                    pci_name.setText("PCI");
                    ci_name.setText("CI:");

                    rsrq_value.setText(String.valueOf(rsrq) + " dB");
                    rsrp_value.setText(String.valueOf(rsrp) + " dbm");
                    rssnr_value.setText(" " + String.valueOf(rssnr) + " dB");
                    asu_value.setText(String.valueOf(rsrp + 140));
                    power_value.setText(dbmToPower(rsrp));

                    tac_value.setText(Integer.toString(cellIdentityLte.getTac()));
                    pci_value.setText(Integer.toString(cellIdentityLte.getPci()));
                    ci_value.setText(Integer.toString(cellIdentityLte.getCi()));

                }
                int number_of_cells = telephon_manager_1.getNeighboringCellInfo().size();
                if(number_of_cells==0){
                    hideTextView(1,0);
                    hideTextView(2,0);
                }
                if(number_of_cells>0){
                    hideTextView(2,0);
                    CellInfoLte cellInfoLte1 = (CellInfoLte) cellInfoList.get(1);
                    CellIdentityLte cellIdentityLte1 = cellInfoLte1.getCellIdentity();

                    int tac_temp = cellIdentityLte1.getTac();
                    if(tac_temp!=2147483647) {

                        CellSignalStrengthLte cellSignalStrengthLte1 = cellInfoLte1.getCellSignalStrength();
                        int signalStrengthValue1 = cellSignalStrengthLte1.getDbm();


                        rsrp_name1.setText("RSRP:");
                        rsrq_name1.setText("");
                        rssnr_name1.setText("");
                        tac_name1.setText("");
                        pci_name1.setText("");
                        ci_name1.setText("");
                        power_name1.setText("Power:");

                        rsrp_value1.setText(String.valueOf(signalStrengthValue1) + " dbm");
                        asu_value1.setText("");
                        power_value1.setText(dbmToPower(signalStrengthValue1));
                        rsrq_value1.setText("");
                        rssnr_value1.setText("");

                        rsrq_value1.setText("");
                        rssnr_value1.setText("");
                        asu_value1.setText("");
                        power_value1.setText("");
                        ci_value1.setText("");
                        pci_value1.setText("");
                        tac_value1.setText("");
                        asu_name1.setText("");

                    }
                    else{
                        hideTextView(1,0);
                    }
                }
                if(number_of_cells>1){
                    CellInfoLte cellInfoLte1 = (CellInfoLte) cellInfoList.get(2);
                    CellIdentityLte cellIdentityLte1 = cellInfoLte1.getCellIdentity();

                    int tac_temp = cellIdentityLte1.getTac();
                    if(tac_temp!=2147483647) {

                        CellSignalStrengthLte cellSignalStrengthLte1 = cellInfoLte1.getCellSignalStrength();
                        int signalStrengthValue1 = cellSignalStrengthLte1.getDbm();


                        rsrp_name1.setText("RSRP:");
                        rsrq_name1.setText("");
                        rssnr_name1.setText("");
                        tac_name1.setText("");
                        pci_name1.setText("");
                        ci_name1.setText("");
                        power_name1.setText("Power:");

                        rsrp_value1.setText(String.valueOf(signalStrengthValue1) + " dbm");
                        asu_value1.setText("");
                        power_value1.setText(dbmToPower(signalStrengthValue1));
                        rsrq_value1.setText("");
                        rssnr_value1.setText("");

                        rsrq_value1.setText("");
                        rssnr_value1.setText("");
                        asu_value1.setText("");
                        power_value1.setText("");
                        ci_value1.setText("");
                        pci_value1.setText("");
                        tac_value1.setText("");
                        asu_name1.setText("");

                    }
                    else{
                        hideTextView(2,0);
                    }
                }

            } else if (telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_HSPAP ||
                    telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_HSPA) {
                Log.i("TAG ", " HSPAP/HAPA");
                signalStrengthValue = signalStrength.getGsmSignalStrength() * 2 - 113;  // dlaczego z sygnału GSM bierzemy sile sygnalu?

                cellInfoList = telephon_manager_1.getAllCellInfo();
                if (cellInfoList != null && (cellInfoList.get(0) instanceof CellInfoWcdma)) {
                    cellInfoWcdma = (CellInfoWcdma) cellInfoList.get(0);
                    cellIdentityWcdma = cellInfoWcdma.getCellIdentity();

                    cellSignalStrengthWcdma = cellInfoWcdma.getCellSignalStrength();
                    signalStrengthValue  = cellSignalStrengthWcdma.getDbm();
                    rsrp_name.setText("RSSI:");
                    rsrq_name.setText("");
                    rssnr_name.setText("");
                    tac_name.setText("LAC:");
                    pci_name.setText("PSC:");
                    ci_name.setText("CID:");

                    rsrp_value.setText(String.valueOf(signalStrengthValue) + " dbm");
                    asu_value.setText(String.valueOf(cellSignalStrengthWcdma.getAsuLevel()));
                    power_value.setText(dbmToPower(signalStrengthValue));
                    rsrq_value.setText("");
                    rssnr_value.setText("");

                    tac_value.setText(Integer.toString(cellIdentityWcdma.getLac()));
                    pci_value.setText(Integer.toString(cellIdentityWcdma.getPsc()));
                    ci_value.setText(Integer.toString(cellIdentityWcdma.getCid()));
                }
                int number_of_cells = telephon_manager_1.getNeighboringCellInfo().size();
                if(number_of_cells==0){

                    hideTextView(1,0);
                    hideTextView(2,0);
                }
                if(number_of_cells>0){
                    hideTextView(2,0);

                    CellInfoWcdma cellInfoWcdma1 = (CellInfoWcdma) cellInfoList.get(1);
                    CellIdentityWcdma cellIdentityWcdma1 = cellInfoWcdma1.getCellIdentity();

                    int lac_temp = cellIdentityWcdma1.getLac();
                    if(lac_temp!=2147483647) {

                        CellSignalStrengthWcdma cellSignalStrengthWcdma1 = cellInfoWcdma.getCellSignalStrength();
                        int signalStrengthValue1 = cellSignalStrengthWcdma1.getDbm();
                        int asuValue = cellSignalStrengthWcdma1.getAsuLevel();

                        Log.i("SILA 1", String.valueOf(cellIdentityWcdma1.getLac()));

                        rsrp_name1.setText("RSSI:");
                        rsrq_name1.setText("");
                        rssnr_name1.setText("");
                        tac_name1.setText("LAC:");
                        pci_name1.setText("PSC:");
                        ci_name1.setText("CID:");


                        rsrp_value1.setText(String.valueOf(signalStrengthValue1) + " dbm");
                        asu_value1.setText(String.valueOf(asuValue));
                        power_value1.setText(dbmToPower(signalStrengthValue1));
                        rsrq_value1.setText("");
                        rssnr_value1.setText("");


                        tac_value1.setText(Integer.toString(lac_temp));
                        pci_value1.setText(Integer.toString(cellIdentityWcdma1.getPsc()));
                        ci_value1.setText(Integer.toString(cellIdentityWcdma1.getCid()));
                    }
                    else{
                        hideTextView(1,0);
                    }
                }
                if(number_of_cells>1){
                    CellInfoWcdma cellInfoWcdma2 = (CellInfoWcdma) cellInfoList.get(2);
                    CellIdentityWcdma cellIdentityWcdma2 = cellInfoWcdma2.getCellIdentity();

                    int lac_temp = cellIdentityWcdma2.getLac();
                    if(lac_temp!=2147483647) {

                        CellSignalStrengthWcdma cellSignalStrengthWcdma2 = cellInfoWcdma.getCellSignalStrength();
                        int signalStrengthValue2 = cellSignalStrengthWcdma2.getDbm();
                        int asuValue2 = cellSignalStrengthWcdma2.getAsuLevel();

                        Log.i("SILA 2", String.valueOf(signalStrengthValue2));

                        rsrp_name2.setText("RSSI:");
                        rsrq_name2.setText("");
                        rssnr_name2.setText("");
                        tac_name2.setText("LAC:");
                        pci_name2.setText("PSC:");
                        ci_name2.setText("CID:");

                        rsrp_value2.setText(String.valueOf(signalStrengthValue2) + " dbm");
                        asu_value2.setText(String.valueOf(asuValue2));
                        power_value2.setText(dbmToPower(signalStrengthValue2));
                        rsrq_value2.setText("");
                        rssnr_value2.setText("");

                        tac_value2.setText(Integer.toString(lac_temp));
                        pci_value2.setText(Integer.toString(cellIdentityWcdma2.getPsc()));
                        ci_value2.setText(Integer.toString(cellIdentityWcdma2.getCid()));
                    }
                    else{
                        hideTextView(2,0);
                    }
                }

            } else if (telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_EDGE ||
                    telephon_manager_1.getNetworkType() == TelephonyManager.NETWORK_TYPE_GPRS) {
                Log.i("TAG ", "EDGE/GPRS");
                signalStrengthValue = signalStrength.getGsmSignalStrength() * 2 - 113;

                cellInfoList = telephon_manager_1.getAllCellInfo();
                if (cellInfoList != null && (cellInfoList.get(0) instanceof CellInfoGsm)) {
                    cellInfoGsm = (CellInfoGsm) cellInfoList.get(0);
                    cellIdentityGsm = cellInfoGsm.getCellIdentity();

                    cellSignalStrengthGsm = cellInfoGsm.getCellSignalStrength();

                    rsrp_name.setText("RSSI:");
                    rsrq_name.setText("");
                    rssnr_name.setText("");
                    tac_name.setText("LAC:");
                    pci_name.setText("");
                    ci_name.setText("CID:");


                    rsrp_value.setText(String.valueOf(signalStrengthValue) + " dbm");
                    asu_value.setText(String.valueOf(cellSignalStrengthGsm.getAsuLevel()));
                    power_value.setText(dbmToPower(signalStrengthValue));
                    rsrq_value.setText("");
                    rssnr_value.setText("");

                    tac_value.setText(Integer.toString(cellIdentityGsm.getLac()));
                    pci_value.setText("");
                    ci_value.setText(Integer.toString(cellIdentityGsm.getCid()));

                    int number_of_cells = telephon_manager_1.getNeighboringCellInfo().size();
                    if(number_of_cells==0){
                        neighbor_name.setText("");
                        hideTextView(1,0);
                        hideTextView(2,0);
                    }
                    if(number_of_cells>0){
                        CellInfoGsm  cellInfoGsm1 = (CellInfoGsm) cellInfoList.get(1);
                        CellIdentityGsm cellIdentityGsm1 = cellInfoGsm1.getCellIdentity();

                        CellSignalStrengthGsm signalStrenght1 =cellInfoGsm1.getCellSignalStrength();
                        int signalStrengthValue1 = signalStrenght1.getDbm();

                        rsrp_name1.setText("RSSI:");
                        rsrq_name1.setText("");
                        rssnr_name1.setText("");
                        tac_name1.setText("LAC:");
                        pci_name1.setText("");
                        ci_name1.setText("CID:");
                        asu_name1.setText("ASU:");
                        power_name1.setText("Power");

                        rsrp_value1.setText(String.valueOf(signalStrengthValue1) + " dbm");
                        asu_value1.setText(String.valueOf(signalStrengthValue + 113));
                        power_value1.setText(dbmToPower(signalStrengthValue1));
                        rsrq_value1.setText("");
                        rssnr_value1.setText("");

                        tac_value1.setText(Integer.toString(cellIdentityGsm1.getLac()));
                        pci_value1.setText("");
                        ci_value1.setText(Integer.toString(cellIdentityGsm1.getCid()));

                    }
                    if(number_of_cells>1){
                        CellInfoGsm  cellInfoGsm2 = (CellInfoGsm) cellInfoList.get(2);
                        CellIdentityGsm cellIdentityGsm2 = cellInfoGsm2.getCellIdentity();

                        CellSignalStrengthGsm signalStrenght2 =cellInfoGsm2.getCellSignalStrength();
                        int signalStrengthValue2 = signalStrenght2.getDbm();

                        rsrp_name2.setText("RSSI:");
                        rsrq_name2.setText("");
                        rssnr_name2.setText("");
                        tac_name2.setText("LAC:");
                        pci_name2.setText("");
                        ci_name2.setText("CID:");
                        asu_name2.setText("ASU:");
                        power_name2.setText("Power:");

                        rsrp_value2.setText(String.valueOf(signalStrengthValue2) + " dbm");
                        asu_value2.setText(String.valueOf(signalStrengthValue2 + 113));
                        power_value2.setText(dbmToPower(signalStrengthValue2));
                        rsrq_value2.setText("");
                        rssnr_value2.setText("");

                        tac_value2.setText(Integer.toString(cellIdentityGsm2.getLac()));
                        pci_value2.setText("");
                        ci_value2.setText(Integer.toString(cellIdentityGsm2.getCid()));
                    }
                }
            }
        }
    }


    private class NetworkPhoneStateListener extends  PhoneStateListener{
        public void onDataConnectionStateChanged(int state, int networkType) {
            String NetTypeStr = null;
            super.onDataConnectionStateChanged(state, networkType);
            switch(telephon_manager_1.getNetworkType()){
                case 0: NetTypeStr = "---"; break;
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

    private class CellInfoStateListener extends PhoneStateListener{  // dokonczyc zeby widziec komoórki sąsiednie
        @Override
        public void onCellInfoChanged(List<CellInfo> cellInfo) {
            super.onCellInfoChanged(cellInfo);

            if (cellInfo != null) {
                for (CellInfo c : cellInfo){
                    if(c.isRegistered()) {
                        if (c instanceof CellInfoLte){
                            cellInfoLte = (CellInfoLte)c;
                            cellIdentityLte = cellInfoLte.getCellIdentity();
                            tac_value.setText(Integer.toString(cellIdentityLte.getTac()));
                            pci_value.setText(Integer.toString(cellIdentityLte.getPci()));
                            ci_value.setText(Integer.toString(cellIdentityLte.getCi()));
                        } else if (c instanceof CellInfoWcdma){
                            cellInfoWcdma = (CellInfoWcdma)c;
                        } else if (c instanceof CellInfoCdma){
                            cellInfoCdma = (CellInfoCdma)c;
                        } else if (c instanceof CellInfoGsm){
                            cellInfoGsm = (CellInfoGsm)c;
                        }
                    }
                }
            }
        }
    }

    private void hideTextView(int index, int lac){
        if(lac !=2147483647){
        if(index==1) {
            rsrq_name1.setText("");
            rssnr_name1.setText("");
            rsrp_name1.setText("");
            rsrp_value1.setText("");
            rsrq_value1.setText("");
            rssnr_value1.setText("");
            asu_value1.setText("");
            power_value1.setText("");
            ci_value1.setText("");
            pci_value1.setText("");
            tac_value1.setText("");
            pci_name1.setText("");
            tac_name1.setText("");
            ci_name1.setText("");
            asu_name1.setText("");
            power_name1.setText("");

        }else if(index==2){
            rsrq_name2.setText("");
            rssnr_name2.setText("");
            rsrp_name2.setText("");
            rsrp_value2.setText("");
            rsrq_value2.setText("");
            rssnr_value2.setText("");
            asu_value2.setText("");
            power_value2.setText("");
            ci_value2.setText("");
            pci_value2.setText("");
            tac_value2.setText("");
            pci_name2.setText("");
            tac_name2.setText("");
            ci_name2.setText("");
            asu_name2.setText("");
            power_name2.setText("");

        }}
        else{
            rsrq_name1.setText("");
            rssnr_name1.setText("");
            rsrp_name1.setText("");
            rsrp_value1.setText("");
            rsrq_value1.setText("");
            rssnr_value1.setText("");
            asu_value1.setText("");
            power_value1.setText("");
            ci_value1.setText("");
            pci_value1.setText("");
            tac_value1.setText("");
            pci_name1.setText("");
            tac_name1.setText("");
            ci_name1.setText("");
            rsrq_name2.setText("");
            rssnr_name2.setText("");
            rsrp_name2.setText("");
            rsrp_value2.setText("");
            rsrq_value2.setText("");
            rssnr_value2.setText("");
            asu_value2.setText("");
            power_value2.setText("");
            ci_value2.setText("");
            pci_value2.setText("");
            tac_value2.setText("");
            pci_name2.setText("");
            tac_name2.setText("");
            ci_name2.setText("");
            asu_name1.setText("");
            power_name1.setText("");
            asu_name2.setText("");
            power_name2.setText("");

        }
    }

    private String dbmToPower(int dbm){
        double p = dbm/ 10.0;
        double power = Math.pow(10, p) * 1000000000;
        Log.i("POWER", String.valueOf(p));

        return String.valueOf(" "+ String.format("%.2f", power) + " pW");
    }
}

