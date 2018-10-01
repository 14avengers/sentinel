package sentinelgroup.io.sentinel.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import sentinelgroup.io.sentinel.network.model.VpnUsageEntity;

/**
 * DAO to do CRUD operation related to VPN usage.
 */
@Dao
public interface VpnUsageEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVpnUsageEntity(VpnUsageEntity iEntity);

    @Query("SELECT * FROM vpn_usage_entity")
    LiveData<VpnUsageEntity> getVpnUsageEntity();
}
