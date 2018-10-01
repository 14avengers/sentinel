package sentinelgroup.io.sentinel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import sentinelgroup.io.sentinel.network.model.Chains;

/**
 * DAO to do CRUD operation related to Wallet Balance.
 */
@Dao
public interface BalanceEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBalanceEntity(Chains iEntity);

    @Query("SELECT * FROM balance_entity")
    LiveData<Chains> getBalanceEntity();
}
