package sentinelgroup.io.sentinel.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import androidx.annotation.NonNull;
import sentinelgroup.io.sentinel.repository.AppVersionRepository;
import sentinelgroup.io.sentinel.repository.BonusRepository;
import sentinelgroup.io.sentinel.repository.CreateAuidRepository;

public class SplashViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final BonusRepository mBonusRepository;
    private final AppVersionRepository mAppVersionRepository;
    private final CreateAuidRepository mCreateAuidRepository;

    public SplashViewModelFactory(BonusRepository iBonusRepository, AppVersionRepository iAppVersionRepository, CreateAuidRepository iCreateAuidRepository) {
        mBonusRepository = iBonusRepository;
        mAppVersionRepository = iAppVersionRepository;
        mCreateAuidRepository = iCreateAuidRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new SplashViewModel(mBonusRepository, mAppVersionRepository, mCreateAuidRepository);
    }
}
