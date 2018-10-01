package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.BonusRepository;
import sentinelgroup.io.sentinel.util.AppExecutors;

public class RestoreKeystoreViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final AppExecutors mAppExecutors;
    private final BonusRepository mBonusRepository;
    private final String mDeviceId;

    public RestoreKeystoreViewModelFactory(AppExecutors iAppExecutors, BonusRepository iBonusRepository, String iDeviceId) {
        mAppExecutors = iAppExecutors;
        mBonusRepository = iBonusRepository;
        mDeviceId = iDeviceId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new RestoreKeystoreViewModel(mAppExecutors, mBonusRepository, mDeviceId);
    }
}
