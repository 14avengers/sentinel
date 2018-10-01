package sentinelgroup.io.sentinel.db.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import sentinelgroup.io.sentinel.network.model.VpnListEntity;

/**
 * DAO to do CRUD operation related to VPN List.
 */
@Dao
public interface VpnListEntryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertVpnListEntity(List<VpnListEntity> iEntity);

    @Query("SELECT * FROM vpn_list_entity")
    LiveData<List<VpnListEntity>> getVpnLisEntity();

    @Query("SELECT * FROM vpn_list_entity WHERE accountAddress = :iVpnAddress")
    LiveData<VpnListEntity> getVpnEntity(String iVpnAddress);

    @Query("DELETE FROM vpn_list_entity")
    void deleteVpnListEntity();
}