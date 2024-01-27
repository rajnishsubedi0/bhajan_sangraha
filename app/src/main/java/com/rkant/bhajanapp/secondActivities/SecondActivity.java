package com.rkant.bhajanapp.secondActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.rkant.bhajanapp.FirstActivities.DataHolder;
import com.rkant.bhajanapp.R;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ArrayList<DataHolder> arrayList;
    RecyclerView recyclerView;
    

String[] bhajanStringArrayFromResources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
        recyclerView = findViewById(R.id.recyclerSecondView);
        arrayList = new ArrayList<DataHolder>();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xff6200ed));
        setData();






        }

    @Override
    //Keeping Screen On
    protected void onStart() {
        super.onStart();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        }, 120000);

    }

    // Setting Data for Recycler view by checking what value is coming through intend so we could assign that intend value to the value in our database
    // and launch new activity accordingly
    private void setData(){

        String string;
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            string=bundle.getString("position");

            if (string.equalsIgnoreCase("जगिदश्वर जय अभिनाशी")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.jaya_jagadisara_jaya_abinashi);
                startLoop();
            }
            else if (string.equalsIgnoreCase("गणपति भक्त लगाउ पार")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.zero_ganapati);
                startLoop();
            }

            else if (string.equalsIgnoreCase("जगिदश्वर जय अभिनाशी")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.jaya_jagadisara_jaya_abinashi);
                startLoop();
            }
            else if (string.equalsIgnoreCase("गोविन्द जय जय, गोपाल जय जय")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.one_govinda);
                startLoop();
            }
            else if (string.equalsIgnoreCase("नाँचे कृष्णजी छमछम नाँचे कृष्णजी")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.two_nachhe_krishna_jee);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण गए बनैमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.three_krishna_gaye_banaima);
                startLoop();
            }
            else if (string.equalsIgnoreCase("पाउँ सँधैभरी मंगल गाउन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.four_pau_sadhaivari_mangala_gauna);
                startLoop();
            }
            else if (string.equalsIgnoreCase("आउन सखि फुलबारीमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.five_aauna_sakhi_fulbarima);
                startLoop();
            }
            else if (string.equalsIgnoreCase("मथुरा खोजेँ गोकुल खोजेँ")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.six_mathura_khoje);
                startLoop();
            }
            else if (string.equalsIgnoreCase("खोजुँ म तिमीलाई कहाँ")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.seven_khoju_ma_timilai_kaha);
                startLoop();
            }
            else if (string.equalsIgnoreCase("सुनन सखि प्यारी")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.eight_sunana_sakhi_pyari);
                startLoop();
            }
            else if (string.equalsIgnoreCase("श्यामले वदन घुम्रिएको बाल")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.nine_shyama_le_badana_ghumriyeko_bal);
                startLoop();
            }
            else if (string.equalsIgnoreCase("वृन्दावन शहर बनेर होकि")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.ten_brindabana_sahara_banera_hoki);
                startLoop();
            }
            else if (string.equalsIgnoreCase("तार्दछौ सारा जमाना")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.eleven_tardaxau_sara_jamana);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण मुरारी, मधुर मधुर वंशी बज्यो")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twelve_krishna_murari);
                startLoop();
            }
            else if (string.equalsIgnoreCase("आउन कृष्ण दर्शन देउन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirteen_aauna_krishna_darshana_deuna);
                startLoop();
            }
            else if (string.equalsIgnoreCase("मुक्तिनाथ गण्डकी दामोदर कुण्ड")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourteen_muktinath_gandaki_damodar_kunda);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कैलाशमा बस्ने, खरानी धस्ने")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fifteen_kailash_main_basne);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कति राम्रो श्री वृन्दावन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.sixteen_kati_ramro_shree_brindabana);
                startLoop();
            }
            else if (string.equalsIgnoreCase("ॐ नमो भगवते वासुदेवाय")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.seventeen_om_namo_bhagwate);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण पियारा, प्रभु बिना त हाम्रो को छर")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.eighteen_krishna_piyara);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कोहि पागल धनले, कोहि पागल मनले")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.nineteen_kohi_pagal_dhana_le);
                startLoop();
            }
            else if (string.equalsIgnoreCase("आए म माता तिम्रो चरणमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twenty_aaye_ma_mata_timro_charan_ma);
                startLoop();
            }
            else if (string.equalsIgnoreCase("यो बाटो कहाँ जाने होला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentyone_yo_bato_kaha_jane_hola);
                startLoop();
            }
            else if (string.equalsIgnoreCase("एकादसि तुलसि")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentytwo_ekadasi_tilako_dan);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण गए यमुना तरेर")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentythree_krishna_gaye_yamuna_tarera);
                startLoop();
            }
            else if (string.equalsIgnoreCase("आगे आगे वाँसुरि वाला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentyfour_aage_aage_basuri_wala);
                startLoop();
            }
            else if (string.equalsIgnoreCase("जय जय हो भोले बाबा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentyfive_jai_jai_ho_bhole_baba);
                startLoop();
            }
            else if (string.equalsIgnoreCase("रामलाई अघि म लाउँला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentysix_ram_lai_aaghi_ma_laula);
                startLoop();
            }
            else if (string.equalsIgnoreCase("गुरु विना ज्ञान कैले मिल्दैन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentyseven_guru_bina_gyan_kaile_mildaina);
                startLoop();
            }
            else if (string.equalsIgnoreCase("जय रामानुज")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentyeight_jaya_ramanuja);
                startLoop();
            }

            //DOUBLE Line repeated
            /*else if (string.equalsIgnoreCase("गुरु विना ज्ञान कैले मिल्दैन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.twentynine_guru_bina_gyan_kaile_mildaina);
                startLoop();
            }*/

            else if (string.equalsIgnoreCase("हे कृष्ण मलाई मीठो वंशी")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirty_hey_krishna_malai_mitho_bansi);
                startLoop();
            }
            else if (string.equalsIgnoreCase("भोलेबाबा मेरो दुःख कष्ट मेटाइदेउ")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtyone_bhole_baba_mero_dukha_kasta_metaideu);
                startLoop();
            }
            else if (string.equalsIgnoreCase("बुन्दावनको डाँडै डाँडा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtytwo_brindaban_ko_dandai_danda);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण गए बनैमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtythree_krishna_gaye_banaima);
                startLoop();
            }
            else if (string.equalsIgnoreCase("जनकपुरमा राम आए दुलाहा बनेर")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtyfour_janakpur_ma_ram_aaye);
                startLoop();
            }
            else if (string.equalsIgnoreCase("छेक्यो मलाई माया जालैले")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtyfive_chhekyo_malai_maya_jaalaile);
                startLoop();
            }
            else if (string.equalsIgnoreCase("राधा तिमी नाचि देउ फिरिरि")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtysix_radha_timi_nachidey_firiri);
                startLoop();
            }
            else if (string.equalsIgnoreCase("बुन्दावनको पाखामा बासुरीको भाकामा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtyseven_brinda_ban_ko_pakha_ma);
                startLoop();
            }
            else if (string.equalsIgnoreCase("हृदयमा कृष्णको फोटो छ")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtyeight_hridaya_ma_krishna_ko_photo_xa);
                startLoop();
            }
            else if (string.equalsIgnoreCase("बाँसुरीको धुन सुनेर")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.thirtynine_bashuri_ko_dhuna_sunera);
                startLoop();
            }
            else if (string.equalsIgnoreCase("शिरमाथि शंकरको चन्द्र झलल")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourty_sira_mathi_sankara_ko_chandra_jhalala);
                startLoop();
            }
            else if (string.equalsIgnoreCase("पुराण लाग्यो हरी तिम्रो मन्दिरैमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtyone_purana_lagyo_hari_timro_mandirai_ma);
                startLoop();
            }
            else if (string.equalsIgnoreCase("हे हरि दर्शन तिम्रो कहाँ होला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtytwo_he_hari_darshana_timro_kaha_hola);
                startLoop();
            }
            else if (string.equalsIgnoreCase("नारायण हो ईश्वरको प्यारो नाम")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtythree_narayana_ho_ishwar_ko_pyaro_naam);
                startLoop();
            }
            else if (string.equalsIgnoreCase("धुन बज्यो धुन बज्यो पक्कै कृष्ण हुन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtyfour_dhun_bajyo_dhun_bajyo_pakkai_krishna_hun);
                startLoop();
            }
            else if (string.equalsIgnoreCase("हे कृष्ण शीरमा मुकुट टलल")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtyfive_hey_krishna_sir_ma_mukut_talala);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्ण भजनमा लाग्यो मेरो मन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtysix_krishna_bhajan_ma_lagyo_mero_man);
                startLoop();
            }
            else if (string.equalsIgnoreCase("रातो फरिया राधाले लगाउँदा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtyseven_rato_fariya_radha_le_lagauda);
                startLoop();
            }
            else if (string.equalsIgnoreCase("नौनी माखन चोरेको किन")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtyeight_nauni_makhan_choreko_kina);
                startLoop();
            }
            else if (string.equalsIgnoreCase("हाम्रो घर आउ है कन्हैया")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fourtynine_hamro_ghar_ma_aau_hai_kanhaiya);
                startLoop();
            }
            else if (string.equalsIgnoreCase("वंशी मीठो कृष्णले बजाको")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fifty_banshi_mitho_krishna_le_bajako);
                startLoop();
            }
            else if (string.equalsIgnoreCase("कृष्णको महिमा गाइरहनु होला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fiftyone_krishna_ko_mahima_gai_rahanu_hola);
                startLoop();
            }
            else if (string.equalsIgnoreCase("के होला प्रभु यो चोला")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.fiftytwo_k_hola_prabhu_yo_chola);
                startLoop();
            }
            else if (string.equalsIgnoreCase("आईदेउन कृष्णजी हाम्राे मनैमा")){
                bhajanStringArrayFromResources =getResources().getStringArray(R.array.aaideuna_krishna_jee_hamro_manaima);
                startLoop();
            }
            else if (string.equalsIgnoreCase("मुटुमेरो सारै जालायौ हरी")){
                bhajanStringArrayFromResources=getResources().getStringArray(R.array.mutu_mero_sarai_jalayeu);
                startLoop();
            }
            //for error handling
            else{
                Toast.makeText(this, "No data passed \"Error occured\"", Toast.LENGTH_SHORT).show();
            }








        }
    // Checking all things finished

    }//----------------------------------------------------------------



    //****************************************************8
//Starting loop and adding string data to array List
    private void startLoop() {
        for(int i = 0; i< bhajanStringArrayFromResources.length; i++){
            arrayList.add(new DataHolder(bhajanStringArrayFromResources[i]));
        }
        //Calling "setting adapter" method
        setAdapter();
    }//***************************************************************




    //************************************************************************
//Setting the adapter
    private void setAdapter() {
        RecyclerAdapter bhajanData_recyclerView=new RecyclerAdapter(arrayList, SecondActivity.this   );
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bhajanData_recyclerView);
    }
//******************************************************
}
