package sentinelgroup.io.sentinel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import sentinelgroup.io.sentinel.network.model.BonusInfoEntity;

/**
 * DAO to do CRUD operation related to Referral Info.
 */
@Dao
public interface BonusInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBonusInfoEntity(BonusInfoEntity iEntity);

    @Query("SELECT * FROM bonus_info_entity")
    LiveData<BonusInfoEntity> getBonusInfoEntity();
}
