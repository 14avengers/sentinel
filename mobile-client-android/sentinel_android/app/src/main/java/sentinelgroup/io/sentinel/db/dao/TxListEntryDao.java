package sentinelgroup.io.sentinel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import sentinelgroup.io.sentinel.network.model.TxListEntity;

/**
 * DAO to do CRUD operation related to Tx History.
 */
@Dao
public interface TxListEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTxListEntity(List<TxListEntity> iEntity);

    @Query("SELECT * FROM tx_list_entity WHERE isEth = :isEth")
    LiveData<List<TxListEntity>> getTxListEntity(boolean isEth);

    @Query("SELECT count(*) FROM tx_list_entity WHERE isEth = :isEth")
    int getItemCount(boolean isEth);
}