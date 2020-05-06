package com.example.itc_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnTambahcharger, btnKurangcharger, btnTambahamouse, btnKurangamouse, btnBeli, btnReset;
    TextView txtJumlahcharger, txtJumlahamouse, txtTotalharga, txtPurchased;
    int jumlahCharger = 0; // di awal = 0
    int jumlahAmouse = 0;
    int totalHarga = 0;
    final int harga_charger = 100000; //harga final
    final int harga_amouse = 24500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahcharger = findViewById(R.id.btntambahcharger);
        btnKurangcharger = findViewById(R.id.btnkurangcharger);
        btnTambahamouse = findViewById(R.id.btntambahamouse);
        btnKurangamouse = findViewById(R.id.btnkurangamouse);
        btnBeli = findViewById(R.id.btnbeli);
        btnReset = findViewById(R.id.btnreset);

        txtJumlahcharger = findViewById(R.id.txtjumlahcharger);
        txtJumlahamouse = findViewById(R.id.txtjumlahamouse);
        txtTotalharga = findViewById(R.id.txttotalharga);
        txtPurchased = findViewById(R.id.txtpurchased);

        txtPurchased.setText(""); // tidak tampak pas awal

        btnTambahcharger.setOnClickListener(this);
        btnKurangcharger.setOnClickListener(this);
        btnTambahamouse.setOnClickListener(this);
        btnKurangamouse.setOnClickListener(this);
        btnBeli.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btntambahcharger:
                tambahPesanan(R.id.btntambahcharger); //masukkan ke fungsi terkait
                break;
            case R.id.btntambahamouse:
                tambahPesanan(R.id.btntambahamouse);
                break;
            case R.id.btnkurangcharger:
                kurangPesanan(R.id.btnkurangcharger);
                break;
            case R.id.btnkurangamouse:
                kurangPesanan(R.id.btnkurangamouse);
                break;
            case R.id.btnbeli:
                txtPurchased.setText("Purchased"); //memunculkan tulisan purchased
                break;
            case R.id.btnreset:
                reset();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId()); //jika id error
        }
    }
    // method operasi tambah
    void tambahPesanan(int asal){
        if(asal == R.id.btntambahcharger) {
            if (jumlahCharger < 10) { // max item 10
                jumlahCharger++; // +1
                totalHarga = totalHarga + harga_charger;
                txtJumlahcharger.setText("" + jumlahCharger); // tampilan berubah
                txtTotalharga.setText("Rp " + totalHarga);
            }
        }
        if(asal==R.id.btntambahamouse) {
            if (jumlahAmouse < 10) {
                jumlahAmouse++;
                totalHarga = totalHarga + harga_amouse;
                txtJumlahamouse.setText("" + jumlahAmouse);
                txtTotalharga.setText("Rp " + totalHarga);
            }
        }
    }
    //method operasi kurang
    void kurangPesanan(int asal){
        if(asal == R.id.btnkurangcharger) {
            if (jumlahCharger > 0) { // jika item <0 tidak akan berkurang lagi
                jumlahCharger--; // -1
                totalHarga = totalHarga - harga_charger;
                txtJumlahcharger.setText("" + jumlahCharger);
                txtTotalharga.setText("Rp " + totalHarga);
            }
        }
        if(asal==R.id.btnkurangamouse) {
            if (jumlahAmouse > 0) {
                jumlahAmouse--;
                totalHarga = totalHarga - harga_amouse;
                txtJumlahamouse.setText("" + jumlahAmouse);
                txtTotalharga.setText("Rp " + totalHarga);
            }
        }
    }
    //method tombol reset
    void reset(){
        jumlahCharger = 0; //semua nilai diset 0
        jumlahAmouse = 0;
        totalHarga = 0;

        txtJumlahamouse.setText("0"); txtJumlahcharger.setText("0"); //tampilan diset 0
        txtPurchased.setText(""); //tulisan purchased tidak muncul
        txtTotalharga.setText("Rp 0");
    }

}
