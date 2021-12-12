package com.example.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("Select * from shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}