package sentinelgroup.io.sentinel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import sentinelgroup.io.sentinel.network.model.GasEstimateEntity;

/**
 * DAO to do CRUD operation related to GAS Estimate.
 */
@Dao
public interface GasEstimateEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertGasEstimateEntity(GasEstimateEntity iEntity);

    @Query("SELECT * FROM gas_estimate_entity")
    LiveData<GasEstimateEntity> getGasEstimateEntity();
}
