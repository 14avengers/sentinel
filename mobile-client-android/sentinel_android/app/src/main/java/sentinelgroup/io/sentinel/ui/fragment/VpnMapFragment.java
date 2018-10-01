package sentinelgroup.io.sentinel.ui.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.shadowsocks.Core;
import com.github.shadowsocks.bg.BaseService;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import sentinelgroup.io.sentinel.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VpnMapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VpnMapFragment extends Fragment {

    private static final int REQUEST_SOCKS5_CONNECT = 999;
    private static int STATE = BaseService.IDLE;

    public VpnMapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment VpnMapFragment.
     */
    public static VpnMapFragment newInstance(String param1, String param2) {
        return new VpnMapFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.tvComingSoon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectSocks5Node();
            }
        });
    }

    private void connectSocks5Node() {
        if (STATE == BaseService.CONNECTED) {
            Core.INSTANCE.stopService();
        } else {
            Intent aSocks5VpnIntent = VpnService.prepare(getActivity());
            if (aSocks5VpnIntent != null) {
                startActivityForResult(aSocks5VpnIntent, REQUEST_SOCKS5_CONNECT);
            } else {
                onActivityResult(REQUEST_SOCKS5_CONNECT, Activity.RESULT_OK, null);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_SOCKS5_CONNECT) {
            super.onActivityResult(requestCode, resultCode, data);
        } else if (resultCode == Activity.RESULT_OK) {
            Core.INSTANCE.startService();
        } else {
            Log.i("VpnMapFragment", "VPN permission denied");
        }
    }
}