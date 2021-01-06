package com.example.datakopi.model

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
 open class coffee:RealmObject() {

    private var id: Int=0
    private var namaKopi:String=""
    private var jenisKopi:String=""
    private var asalKopi:String=""
    private var stok:String=""

    fun setId(id:Int){
        this.id =id
    }
    fun getId():Int{
        return id
    }
    fun setNamaKopi(NamaKopi:String){
        this.namaKopi = NamaKopi
    }
    fun getNamaKopi():String{
        return namaKopi
    }
    fun setJenisKopi(JenisKopi:String){
        this.jenisKopi=JenisKopi
    }
    fun getJenisKopi():String{
        return jenisKopi
    }
    fun setAsalKopi(AsalKopi : String){
        this.asalKopi = AsalKopi
    }
    fun  getAsalKopi ():String{
        return asalKopi
    }
    fun setStok(stok: String){
        this.stok = stok
    }
    fun getStok():String{
        return stok
    }
}