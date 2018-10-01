package sentinelgroup.io.sentinel.network.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

import sentinelgroup.io.sentinel.db.typeconverters.SessionListTypeConverter;

@Entity(tableName = "vpn_usage_entity", indices = {@Index(value = {"id"}, unique = true)})
public class VpnUsageEntity {
    @PrimaryKey
    private int id = 1;
    private long due;
    @Embedded(prefix = "stats_")
    private Stats stats;
    @TypeConverters(SessionListTypeConverter.class)
    private List<Session> sessions = new ArrayList<>();
    // To getGenericWebService current usage
    @Ignore
    public long down;
    @Ignore
    public long up;

    public VpnUsageEntity(long due, Stats stats, List<Session> sessions) {
        this.due = due;
        this.stats = stats;
        this.sessions.addAll(sessions);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDue() {
        return due;
    }

    public void setDue(long due) {
        this.due = due;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
