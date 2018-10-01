package sentinelgroup.io.sentinel.network.model;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NetSpeed implements Serializable {
    public double download;
    public double upload;
    @Ignore
    @SerializedName("best_server")
    public BestServer bestServer;
}
