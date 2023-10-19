package com.example.mvvmdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuoteDao {

    // no need for suspend because LiveData Already run it on background thread
    @Query("Select * from quote")
    fun getQuotes() :LiveData<List<Quote>>

    //suspend because of background thread
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: Quote)
}