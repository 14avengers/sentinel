package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import sentinelgroup.io.sentinel.network.model.GenericRequestBody;
import sentinelgroup.io.sentinel.network.model.VpnUsageEntity;
import sentinelgroup.io.sentinel.repository.VpnRepository;
import sentinelgroup.io.sentinel.util.AppConstants;
import sentinelgroup.io.sentinel.util.AppPreferences;

public class VpnHistoryViewModel extends ViewModel {
    private final VpnRepository mRepository;
    private final LiveData<VpnUsageEntity> mVpnUsageLiveEvent;

    VpnHistoryViewModel(VpnRepository iRepository) {
        mRepository = iRepository;
        mVpnUsageLiveEvent = iRepository.getVpnUsageEntity();
    }

    private GenericRequestBody getRequestBody() {
        String aAccountAddress = AppPreferences.getInstance().getString(AppConstants.PREFS_ACCOUNT_ADDRESS);
        return new GenericRequestBody.GenericRequestBodyBuilder().accountAddress(aAccountAddress).build();
    }

    public LiveData<VpnUsageEntity> getVpnUsageLiveEvent() {
        return mVpnUsageLiveEvent;
    }

    public void reloadVpnUsage() {
        mRepository.getVpnUsageForUser(getRequestBody());
    }
}