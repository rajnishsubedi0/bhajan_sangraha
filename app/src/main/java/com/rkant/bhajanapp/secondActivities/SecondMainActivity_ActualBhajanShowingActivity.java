package com.rkant.bhajanapp.secondActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.rkant.bhajanapp.FirstActivities.Main_DataHolderUsingArraylist;
import com.rkant.bhajanapp.R;

import java.util.ArrayList;

public class SecondMainActivity_ActualBhajanShowingActivity extends AppCompatActivity {
    ArrayList<Main_DataHolderUsingArraylist> arrayList;
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    

String[] strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);
        recyclerView = findViewById(R.id.recyclerSecondView);
        arrayList = new ArrayList<Main_DataHolderUsingArraylist>();

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
        }, 100000);

    }

    // Setting Data for Recycler view by checking what value is coming through intend so we could assign that intend value to the value in our database
    // and launch new activity accordingly
    private void setData(){
        Integer integer = null;
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            integer=bundle.getInt("position");
            if (integer==0){
                strings=getResources().getStringArray(R.array.zero_ganapati);
                startLoop();
            }
            else if (integer==1){
                strings=getResources().getStringArray(R.array.one_govinda);
                startLoop();
            }
            else if (integer==2){
                strings=getResources().getStringArray(R.array.two_nachhe_krishna_jee);
                startLoop();
            }
            else if (integer==3){
                strings=getResources().getStringArray(R.array.three_krishna_gaye_banaima);
                startLoop();
            }
            else if (integer==4){
                strings=getResources().getStringArray(R.array.four_pau_sadhaivari_mangala_gauna);
                startLoop();
            }
            else if (integer==5){
                strings=getResources().getStringArray(R.array.five_aauna_sakhi_fulbarima);
                startLoop();
            }
            else if (integer==6){
                strings=getResources().getStringArray(R.array.six_mathura_khoje);
                startLoop();
            }
            else if (integer==7){
                strings=getResources().getStringArray(R.array.seven_khoju_ma_timilai_kaha);
                startLoop();
            }
            else if (integer==8){
                strings=getResources().getStringArray(R.array.eight_sunana_sakhi_pyari);
                startLoop();
            }
            else if (integer==9){
                strings=getResources().getStringArray(R.array.nine_shyama_le_badana_ghumriyeko_bal);
                startLoop();
            }
            else if (integer==10){
                strings=getResources().getStringArray(R.array.ten_brindabana_sahara_banera_hoki);
                startLoop();
            }
            else if (integer==11){
                strings=getResources().getStringArray(R.array.eleven_tardaxau_sara_jamana);
                startLoop();
            }
            else if (integer==12){
                strings=getResources().getStringArray(R.array.twelve_krishna_murari);
                startLoop();
            }
            else if (integer==13){
                strings=getResources().getStringArray(R.array.thirteen_aauna_krishna_darshana_deuna);
                startLoop();
            }
            else if (integer==14){
                strings=getResources().getStringArray(R.array.fourteen_muktinath_gandaki_damodar_kunda);
                startLoop();
            }
            else if (integer==15){
                strings=getResources().getStringArray(R.array.fifteen_kailash_main_basne);
                startLoop();
            }
            else if (integer==16){
                strings=getResources().getStringArray(R.array.sixteen_kati_ramro_shree_brindabana);
                startLoop();
            }
            else if (integer==17){
                strings=getResources().getStringArray(R.array.seventeen_om_namo_bhagwate);
                startLoop();
            }
            else if (integer==18){
                strings=getResources().getStringArray(R.array.eighteen_krishna_piyara);
                startLoop();
            }
            else if (integer==19){
                strings=getResources().getStringArray(R.array.nineteen_kohi_pagal_dhana_le);
                startLoop();
            }
            else if (integer==20){
                strings=getResources().getStringArray(R.array.twenty_aaye_ma_mata_timro_charan_ma);
                startLoop();
            }
            else if (integer==21){
                strings=getResources().getStringArray(R.array.twentyone_yo_bato_kaha_jane_hola);
                startLoop();
            }
            else if (integer==22){
                strings=getResources().getStringArray(R.array.twentytwo_ekadasi_tilako_dan);
                startLoop();
            }
            else if (integer==23){
                strings=getResources().getStringArray(R.array.twentythree_krishna_gaye_yamuna_tarera);
                startLoop();
            }
            else if (integer==24){
                strings=getResources().getStringArray(R.array.twentyfour_aage_aage_basuri_wala);
                startLoop();
            }
            else if (integer==25){
                strings=getResources().getStringArray(R.array.twentyfive_jai_jai_ho_bhole_baba);
                startLoop();
            }
            else if (integer==26){
                strings=getResources().getStringArray(R.array.twentysix_ram_lai_aaghi_ma_laula);
                startLoop();
            }
            else if (integer==27){
                strings=getResources().getStringArray(R.array.twentyseven_guru_bina_gyan_kaile_mildaina);
                startLoop();
            }
            else if (integer==28){
                strings=getResources().getStringArray(R.array.twentyeight_jaya_ramanuja);
                startLoop();
            }
            else if (integer==29){
                strings=getResources().getStringArray(R.array.twentynine_guru_bina_gyan_kaile_mildaina);
                startLoop();
            }
            else if (integer==30){
                strings=getResources().getStringArray(R.array.thirty_hey_krishna_malai_mitho_bansi);
                startLoop();
            }
            else if (integer==31){
                strings=getResources().getStringArray(R.array.thirtyone_bhole_baba_mero_dukha_kasta_metaideu);
                startLoop();
            }
            else if (integer==32){
                strings=getResources().getStringArray(R.array.thirtytwo_brindaban_ko_dandai_danda);
                startLoop();
            }
            else if (integer==33){
                strings=getResources().getStringArray(R.array.thirtythree_krishna_gaye_banaima);
                startLoop();
            }
            else if (integer==34){
                strings=getResources().getStringArray(R.array.thirtyfour_janakpur_ma_ram_aaye);
                startLoop();
            }
            else if (integer==35){
                strings=getResources().getStringArray(R.array.thirtyfive_chhekyo_malai_maya_jaalaile);
                startLoop();
            }
            else if (integer==36){
                strings=getResources().getStringArray(R.array.thirtysix_radha_timi_nachidey_firiri);
                startLoop();
            }
            else if (integer==37){
                strings=getResources().getStringArray(R.array.thirtyseven_brinda_ban_ko_pakha_ma);
                startLoop();
            }
            else if (integer==38){
                strings=getResources().getStringArray(R.array.thirtyeight_hridaya_ma_krishna_ko_photo_xa);
                startLoop();
            }
            else if (integer==39){
                strings=getResources().getStringArray(R.array.thirtynine_bashuri_ko_dhuna_sunera);
                startLoop();
            }
            else if (integer==40){
                strings=getResources().getStringArray(R.array.fourty_sira_mathi_sankara_ko_chandra_jhalala);
                startLoop();
            }
            else if (integer==41){
                strings=getResources().getStringArray(R.array.fourtyone_purana_lagyo_hari_timro_mandirai_ma);
                startLoop();
            }
            else if (integer==42){
                strings=getResources().getStringArray(R.array.fourtytwo_he_hari_darshana_timro_kaha_hola);
                startLoop();
            }
            else if (integer==43){
                strings=getResources().getStringArray(R.array.fourtythree_narayana_ho_ishwar_ko_pyaro_naam);
                startLoop();
            }
            else if (integer==44){
                strings=getResources().getStringArray(R.array.fourtyfour_dhun_bajyo_dhun_bajyo_pakkai_krishna_hun);
                startLoop();
            }
            else if (integer==45){
                strings=getResources().getStringArray(R.array.fourtyfive_hey_krishna_sir_ma_mukut_talala);
                startLoop();
            }
            else if (integer==46){
                strings=getResources().getStringArray(R.array.fourtysix_krishna_bhajan_ma_lagyo_mero_man);
                startLoop();
            }
            else if (integer==47){
                strings=getResources().getStringArray(R.array.fourtyseven_rato_fariya_radha_le_lagauda);
                startLoop();
            }
            else if (integer==48){
                strings=getResources().getStringArray(R.array.fourtyeight_nauni_makhan_choreko_kina);
                startLoop();
            }
            else if (integer==49){
                strings=getResources().getStringArray(R.array.fourtynine_hamro_ghar_ma_aau_hai_kanhaiya);
                startLoop();
            }
            else if (integer==50){
                strings=getResources().getStringArray(R.array.fifty_banshi_mitho_krishna_le_bajako);
                startLoop();
            }
            else if (integer==51){
                strings=getResources().getStringArray(R.array.fiftyone_krishna_ko_mahima_gai_rahanu_hola);
                startLoop();
            }
            else if (integer==52){
                strings=getResources().getStringArray(R.array.fiftytwo_k_hola_prabhu_yo_chola);
                startLoop();
            }








        }
    // Checking all things finished

    }//----------------------------------------------------------------



    //****************************************************8
//Starting loop and adding string data to array List
    private void startLoop() {
        for(int i=0;i<strings.length;i++){
            arrayList.add(new Main_DataHolderUsingArraylist(strings[i]));
        }
        //Calling "setting adapter" method
        setAdapter();
    }//***************************************************************




    //************************************************************************
//Setting the adapter
    private void setAdapter() {
        SecondView_RecyclerView bhajanData_recyclerView=new SecondView_RecyclerView(arrayList, SecondMainActivity_ActualBhajanShowingActivity.this   );
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(bhajanData_recyclerView);
    }
//******************************************************
}
