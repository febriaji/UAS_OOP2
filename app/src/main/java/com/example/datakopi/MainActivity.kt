package com.example.datakopi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datakopi.adapter.CoffeeAdapter
import com.example.datakopi.model.coffee
import io.realm.Realm
import io.realm.exceptions.RealmException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var CoffeeAdapter: CoffeeAdapter
    lateinit var realm : Realm
    val LayoutManage = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        btn_add.setOnClickListener {
            realm.beginTransaction()
            var count = 0
            realm.where(coffee::class.java).findAll().let {
                for (i in it){
                    count++
                }
            }
            try {
                var coffee = realm.createObject(coffee::class.java)
                coffee.setId(count+1)
                coffee.setNamaKopi(et_namaKopi.text.toString())
                coffee.setJenisKopi(et_jenisKopi.text.toString())
                coffee.setAsalKopi(et_asalKopi.text.toString())
                coffee.setStok(et_stok.text.toString())
                et_namaKopi.setText("")
                et_jenisKopi.setText("")
                et_asalKopi.setText("")
                et_stok.setText("")
                realm.commitTransaction()
                getAllCoffee()
            }catch ( e: RealmException){}
        }
        btn_update.setOnClickListener {
            realm.beginTransaction()
            realm.where(coffee::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.setNamaKopi(et_namaKopi.text.toString())
                it!!.setJenisKopi(et_jenisKopi.text.toString())
                it!!.setAsalKopi(et_asalKopi.text.toString())
                it!!.setStok(et_stok.text.toString())
            }
            realm.commitTransaction()
            getAllCoffee()
        }
        btn_delete.setOnClickListener {
            realm.beginTransaction()
            realm.where(coffee::class.java).equalTo("id", et_id.text.toString().toInt()).findFirst().let {
                it!!.deleteFromRealm()
            }
            realm.commitTransaction()
            getAllCoffee()
        }

    }

    private fun initView(){
        rv_kopi.layoutManager = LayoutManage
        CoffeeAdapter = CoffeeAdapter(this)
        rv_kopi.adapter = CoffeeAdapter
        Realm.init(applicationContext)
        realm = Realm.getDefaultInstance()

    }
    private fun getAllCoffee(){
        realm.where(coffee::class.java).findAll().let {
            CoffeeAdapter.setCoffee(it)
        }
    }
}